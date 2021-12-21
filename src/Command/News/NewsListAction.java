package Command.News;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NewsDAO;
import DTO.NewsVO;

public class NewsListAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		NewsDAO ndao = NewsDAO.getInstance();
		int pno = Integer.parseInt(request.getParameter("pno"));
		int ncount = ndao.getNewsCount(pno);
		
		if(ncount > 0) {
			List<NewsVO> list = ndao.getNewsList(pno);
			List<NewsVO> nlist = new ArrayList();
			for(NewsVO nvo : list) {
				int nno = nvo.getNno();
				int nccount = ndao.getNewsCommentCount(nno);
				nvo.setNccount(nccount);
				nlist.add(nvo);
			}
			request.setAttribute("nlist", nlist);
		}
		
	}

}
