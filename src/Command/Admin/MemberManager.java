package Command.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;
import DTO.MemberVO;
import DTO.SponserDetailVO;

public class MemberManager implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		AdminDAO adao = AdminDAO.getInstance();
		
		MemberVO mvo = adao.memberDetail(id);
		List<SponserDetailVO> slist = adao.memberSponserDetail(id);
	
		request.setAttribute("mvo", mvo);
		request.setAttribute("slist", slist);
	}

}
