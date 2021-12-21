package Command.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;
import DTO.ProjectVO;
import DTO.RewardVO;

public class adminprojectview implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		AdminDAO adao = AdminDAO.getInstance();
		
		ProjectVO plist = adao.selectProjectView(pno);
	//	System.out.println(plist.getCategoryname());
		
		request.setAttribute("plist", plist);
		List<RewardVO> rlist = adao.rewardList(pno);
		
		request.setAttribute("rlist", rlist);
	
	}

}
