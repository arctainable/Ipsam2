package Command.Event;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Command.Command;
import DAO.EventDAO;
import DTO.EventVO;

public class eventwritePro implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
		HttpSession session = request.getSession();
		
		int sizeLimit = 5 * 1024 *1024;
		String savePath = "eventupload";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println(uploadFilePath);
		
		MultipartRequest multi;
		
		EventVO evo = new EventVO();
		EventDAO edao = EventDAO.getInstance();
		
	
		
			multi = new MultipartRequest(request, uploadFilePath, sizeLimit,"UTF-8", new DefaultFileRenamePolicy());
			String image = multi.getFilesystemName("file");
			evo.setTitle(multi.getParameter("title"));
			evo.setContent(multi.getParameter("content"));
			evo.setWriter(multi.getParameter("writer"));
			evo.setThumbnail(image);
			edao.insertNotice(evo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
