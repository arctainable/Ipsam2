package Command.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NoticeDAO;
import DTO.NoticeVO;

public class noticedelete implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		ndao.deletenotice(bno);

	}

}
