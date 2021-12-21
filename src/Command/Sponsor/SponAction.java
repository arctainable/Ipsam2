package Command.Sponsor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.ProjectDAO;
import DAO.RewardDAO;
import DAO.SponsorDAO;
import DTO.MemberVO;
import DTO.ProjectVO;
import DTO.SponsorVO;

public class SponAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {

			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			}else {
				int pno = Integer.parseInt(request.getParameter("t_pno"));
				int rno = Integer.parseInt(request.getParameter("t_rno"));
				String userid = User.getId();
				int rmoney = Integer.parseInt(request.getParameter("t_rmoney"));
				
				String postcode = request.getParameter("postcode");
				String roadaddress = request.getParameter("roadaddress");
				String jibunaddress = request.getParameter("jibunaddress");
				String detailaddress = request.getParameter("detailaddress");
				String extraaddress = request.getParameter("extraaddress");
				
				String address = postcode + " " +roadaddress + " " +jibunaddress+" "+ detailaddress + " " +extraaddress;
				System.out.println(address);
				SponsorVO svo = new SponsorVO();
				svo.setPno(pno);
				svo.setRno(rno);
				svo.setId(userid);
				svo.setSmoney(rmoney);
				svo.setAddress(address);
				
				SponsorDAO sdao = SponsorDAO.getInstance();
				int result = sdao.setSponsor(svo);
				if(result > 0) {
					ProjectDAO pdao = ProjectDAO.getInstance();
					pdao.setProjectSponMoney(pno, rmoney);
					ProjectVO pvo = pdao.getProjectView(pno);
					
					
					RewardDAO rdao = RewardDAO.getInstance();
					rdao.setRewardCountUp(pno, rno);
					
					int count = pdao.getProjectSponCount(pno);
					
					request.setAttribute("pvo", pvo);
					request.setAttribute("count", count);
					request.getRequestDispatcher("project/project-complete.jsp").forward(request, response);
				}else {
					response.sendRedirect("faq.do");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
