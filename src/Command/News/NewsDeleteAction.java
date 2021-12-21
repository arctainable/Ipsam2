package Command.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NewsDAO;

public class NewsDeleteAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NewsDAO ndao = NewsDAO.getInstance();
		ndao.setNewsDelete(nno);

		response.sendRedirect("community.do?pno="+pno);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
