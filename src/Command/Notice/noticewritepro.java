package Command.Notice;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Command.Command;
import DAO.NoticeDAO;
import DTO.NoticeVO;

public class noticewritepro implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int sizeLimit = 5 * 1024 *1024;
		String savePath = "noticeupload";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println(uploadFilePath);
		
		MultipartRequest multi;
		
		NoticeVO nvo = new NoticeVO();
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		try {
			multi = new MultipartRequest(request, uploadFilePath, sizeLimit,"UTF-8", new DefaultFileRenamePolicy());
			
			nvo.setTitle(multi.getParameter("title"));
			nvo.setContent(multi.getParameter("content"));
			nvo.setWriter(multi.getParameter("writer"));
			ndao.insertNotice(nvo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
