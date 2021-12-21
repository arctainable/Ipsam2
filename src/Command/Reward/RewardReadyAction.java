package Command.Reward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.ProjectDAO;
import DAO.RewardDAO;
import DTO.MemberVO;
import DTO.ProjectVO;
import DTO.RewardVO;

public class RewardReadyAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {

			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			}else {
				String userid = User.getId();
				int rno = Integer.parseInt(request.getParameter("t_rno"));
				int pno = Integer.parseInt(request.getParameter("t_pno"));
				
				ProjectDAO pdao = ProjectDAO.getInstance();
				ProjectVO pvo = pdao.getProjectView(pno);
				
				RewardDAO rdao = RewardDAO.getInstance();
				RewardVO rvo = rdao.getRewardSelect(pno, rno);
				
				request.setAttribute("pvo", pvo);
				request.setAttribute("rvo", rvo);
				
				request.getRequestDispatcher("project/project-order.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
