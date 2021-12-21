package Command.Event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;
import DTO.EventVO;

public class eventmanger implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		EventDAO edao = EventDAO.getInstance();

		
		List<EventVO> elist = edao.selectEventList();
		
		
		request.setAttribute("elist", elist);
	}

}
