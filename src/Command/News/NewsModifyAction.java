package Command.News;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Command.Command;
import DAO.NewsDAO;
import DTO.MemberVO;
import DTO.NewsVO;

public class NewsModifyAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {

			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			}else {
				
				int sizeLimit = 5 * 1024 * 1024;
				String savePath = "projectupload";
				ServletContext context = session.getServletContext();
				String uploadFilePath = context.getRealPath(savePath);
				
				MultipartRequest multi;
				multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
				
				
				int pno = Integer.parseInt(multi.getParameter("pno"));
				int nno = Integer.parseInt(multi.getParameter("nno"));
				String content = multi.getParameter("content");
				
				NewsVO nvo = new NewsVO();
				nvo.setNno(nno);
				nvo.setPno(pno);
				nvo.setNcontent(content);
				
				NewsDAO ndao = NewsDAO.getInstance();
				ndao.setNewsModify(nvo);
				
				response.sendRedirect("community.do?pno="+pno);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
