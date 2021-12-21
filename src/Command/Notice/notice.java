package Command.Notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;
import DAO.NoticeDAO;
import DTO.EventVO;
import DTO.NoticeVO;

public class notice implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		List<NoticeVO> nlist = ndao.selectNoticeList();
		
		request.setAttribute("nlist", nlist);
		
		EventDAO edao = EventDAO.getInstance();
		
		List<EventVO> elist = edao.selectEventList();
		
		request.setAttribute("elist", elist);
	
	}

}
