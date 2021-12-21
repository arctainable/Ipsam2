package Command.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.ProjectDAO;
import DTO.MemberVO;
import DTO.ProjectVO;

public class ProjectDeleteAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			} else {
				
				int pno = Integer.parseInt(request.getParameter("pno"));
				String id = User.getId();
				
				ProjectDAO pdao = ProjectDAO.getInstance();
				
				ProjectVO pvo = pdao.getProjectView(pno);
				
				if(pvo.getId().equals(User.getId())) {
					if(pvo.getPgrade()==1 || pvo.getPgrade()==0) {
						pdao.setProjectDelete(pno);
						pdao.setRewardDelete(pno);
						response.sendRedirect("myproject.do");
					}else {
						response.sendRedirect("main.do");
					}
				}else {
					response.sendRedirect("main.do");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
