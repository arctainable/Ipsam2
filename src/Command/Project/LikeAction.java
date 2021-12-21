package Command.Project;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.ProjectDAO;

public class LikeAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			int pno = Integer.parseInt(request.getParameter("pno"));
			String id = request.getParameter("userid");
			
			PrintWriter out = response.getWriter();
			ProjectDAO pdao = ProjectDAO.getInstance();
			int	result = pdao.getProjectLikeUpdate(pno, id);
			
			if(result > 0) {
				int likecount = pdao.getProjectLikeCount(pno);
				System.out.println(likecount);
				out.print(likecount);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
