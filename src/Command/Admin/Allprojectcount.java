package Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;

public class Allprojectcount implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		AdminDAO adao = AdminDAO.getInstance();
		
		int count =adao.AllprojectCount();
		int Ncheckcount = adao.NcheckprojectCount();
		int TodayEndcount = adao.TodayEndProject();
		int TodayJoincount = adao.TodayJoincount();
		
		
		request.setAttribute("count", count);
		request.setAttribute("Ncheckcount", Ncheckcount);
		request.setAttribute("TodayEndcount", TodayEndcount);
		request.setAttribute("TodayJoincount", TodayJoincount);
		
		
	}
}
