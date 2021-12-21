package Command.News;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NewsDAO;
import DTO.NewsVO;
import DTO.News_CommentVO;

public class NewsViewAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NewsDAO ndao = NewsDAO.getInstance();
		NewsVO nvo = ndao.getNewsView(nno);
		int nccount = ndao.getNewsCommentCount(nno);
		
		nvo.setNccount(nccount);
		List<News_CommentVO> list = ndao.getCommentList(nno);
		
		
		request.setAttribute("nvo", nvo);
		request.setAttribute("clist", list);

	}

}
