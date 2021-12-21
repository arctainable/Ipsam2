package Command.Event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;
import DAO.NoticeDAO;
import DTO.EventVO;
import DTO.NoticeVO;

public class eventview implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		EventDAO edao = EventDAO.getInstance();
		EventVO evo = edao.selectEventList(bno);
		request.setAttribute("evo", evo);
		
		
		List<NoticeVO> nlist = ndao.selectNoticeList();
		request.setAttribute("nlist", nlist);

	}

}
