package Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;

public class projectgrademodify implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int pno =  Integer.parseInt(request.getParameter("pno"));
		 int grade = Integer.parseInt(request.getParameter("grade_no"));
		
		AdminDAO adao = AdminDAO.getInstance();
		
		adao.updateProjectGrade(grade,pno);

	}

}
