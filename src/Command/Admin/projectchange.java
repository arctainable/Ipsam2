package Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;

public class projectchange implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDAO adao = AdminDAO.getInstance();
		
		String pchange = request.getParameter("pchange");
		
		String[] pnoArr = request.getParameterValues("chk");
		System.out.println(pchange);
		if(pchange.equals("Y")) {
			for(String pno:pnoArr) {
				adao.changeOK(pno);
			}
			
		}if(pchange.equals("N")) {
			for(String pno:pnoArr) {
				adao.changeNotOK(pno);
			}
		}
	}

}
