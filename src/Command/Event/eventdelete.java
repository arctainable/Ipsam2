package Command.Event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;

public class eventdelete implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		EventDAO edao = EventDAO.getInstance();
		edao.deleteEvent(bno);

	}

}
