package Command.News_Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.NewsDAO;
import DTO.MemberVO;

public class CommentDeleteAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			if (User == null) {
				response.sendRedirect("login.do");
			} else {
				int cno = Integer.parseInt(request.getParameter("cno"));
				String id = User.getId();
				
				NewsDAO ndao = NewsDAO.getInstance();
				ndao.setCommentDelete(id,cno);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
