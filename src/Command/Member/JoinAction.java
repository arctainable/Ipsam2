package Command.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Command.Command;
import DAO.MemberDAO;
import DTO.MemberVO;
import Util.Utility;

public class JoinAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MemberVO mvo = new MemberVO();
			
			mvo.setId(request.getParameter("id"));
			mvo.setName(request.getParameter("name"));
			mvo.setPw(Utility.encoding(request.getParameter("pw2")));
			mvo.setEmail(request.getParameter("email"));
			
			MemberDAO mdao = MemberDAO.getInstance();
			
			int result = mdao.setMemberInsert(mvo);
			
			if(result == 0) {
				System.out.println("회원가입 실패");
				response.sendRedirect("join.do");
			}else if(result > 0) {
				System.out.println("회원가입 성공");
				request.getRequestDispatcher("member/joinok.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
