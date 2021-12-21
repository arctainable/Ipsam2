package Command.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DTO.MemberVO;

public class NewsWriteAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {

			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			}else {
				int pno = Integer.parseInt(request.getParameter("pno"));
				request.setAttribute("pno", pno);
				request.getRequestDispatcher("project/project-community-write.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
