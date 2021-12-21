package Command.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NoticeDAO;
import DTO.NoticeVO;

public class noticeadminview implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		NoticeVO nvo = ndao.selectNoticeView(bno);
		
		request.setAttribute("nvo", nvo);
	}

}
