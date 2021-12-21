package Command.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.MemberDAO;
import DTO.MemberVO;
import Util.Utility;

public class LoginAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			
			String id = request.getParameter("id");
			String pw = Utility.encoding(request.getParameter("pw"));
			System.out.println(pw);
			MemberDAO mdao = MemberDAO.getInstance();
			MemberVO mvo = mdao.getMemberLogin(id);
			
			if(mvo != null) {
				if(mvo.getPw().equals(pw)) {
					session.setAttribute("User", mvo);
					session.setAttribute("ID", id);
					response.sendRedirect("main.do");
				}else {
					session.setAttribute("message", "아이디와 패스워드 확인 바람니다");
					response.sendRedirect("login.do");
				}
			}else {
				session.setAttribute("message", "아이디와 패스워드 확인 바람니다");
				response.sendRedirect("login.do");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
