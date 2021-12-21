package Command.News_Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import Command.Command;
import DAO.NewsDAO;
import DTO.MemberVO;
import DTO.News_CommentVO;

public class CommentInsertAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			
			String comment = request.getParameter("comment");
			int nno = Integer.parseInt(request.getParameter("nno"));
			
			News_CommentVO ncvo = new News_CommentVO();
			
			ncvo.setId(User.getId());
			ncvo.setNcomment(comment);
			ncvo.setNno(nno);
			NewsDAO ndao = NewsDAO.getInstance();
			int cno = ndao.setCommentInsert(ncvo);
			
			String profile = User.getProfile();
			String name = User.getName();
			String id = User.getId();
			
			
			JSONObject obj = new JSONObject();
			obj.put("profile", profile);
			obj.put("name", name);
			obj.put("comment", comment);
			obj.put("id", id);
			obj.put("cno", cno);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json; charest-utf-8");
			response.getWriter().print(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
