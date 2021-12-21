package Command.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.ProjectDAO;
import DTO.ProjectVO;

public class ReleaseViewAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int pno = Integer.parseInt(request.getParameter("pno"));

		ProjectDAO pdao = ProjectDAO.getInstance();
		
		ProjectVO pvo = pdao.getProjectView(pno);
		
		request.setAttribute("rpvo", pvo);
	}

}
