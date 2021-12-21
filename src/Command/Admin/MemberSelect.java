package Command.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;
import DTO.MemberVO;
import DTO.PageVO;
import Util.Criteria;

public class MemberSelect implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pageNum= 1;
		int amount =10;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		String word =""; String query="";
		word = request.getParameter("word");
		
		if(word != null) {
			query = "id like '%" + word + "%'or name like '%" + word + "%'";
		}
		
		
		AdminDAO adao = AdminDAO.getInstance();
		Criteria cri = new Criteria();
		
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		cri.setKeyword(word);
		
		//List<MemberVO> member_list = adao.memberSelect();//조회
		List<MemberVO> member_list = adao.getListWithPaging(cri,query);
		int memberCount = adao.MemberCount(query);//총
		PageVO pvo = new PageVO(cri, memberCount);
		
		request.setAttribute("member_list", member_list);
		request.setAttribute("memberCount", memberCount);
		request.setAttribute("pageMaker", pvo);
	}

}
