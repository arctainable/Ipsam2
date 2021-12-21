package Command.Notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;
import DAO.NoticeDAO;
import DTO.EventVO;
import DTO.NoticeVO;

public class noticeview implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		ndao.noticeViewcount(bno);
		NoticeVO nvo = ndao.selectNoticeView(bno);
		request.setAttribute("nvo", nvo);
		
		
		EventDAO edao = EventDAO.getInstance();
		List<EventVO> elist = edao.selectEventList();
		request.setAttribute("elist", elist);
	
	}

}
