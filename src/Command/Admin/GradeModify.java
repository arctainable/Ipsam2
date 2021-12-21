package Command.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;

public class GradeModify implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		//System.out.println(id);
        int grade = Integer.parseInt(request.getParameter("grade_no"));
        
		AdminDAO adao = AdminDAO.getInstance();
		
		adao.grademodify(id,grade);
	}

}
