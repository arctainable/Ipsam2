package Command.Project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.ProjectDAO;
import DTO.ProjectVO;
import javafx.beans.binding.When;

public class ListAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		String category = "";
		String word="";
		String query= "";
		
		
		if(request.getParameter("word") != null) {
			word = request.getParameter("word");
		};

		if(word != null && word !="") {
			query = "and pname2 like "+" '%"+word+"%'";
			request.setAttribute("word", word);
		};
		
		if(request.getParameter("category") != null)  {
			category = request.getParameter("category");
			switch (category) {
			case "paint":
				query = query + "and categoryno = 1 ";
				break;
			case "photo":
				query = query + "and categoryno = 2 ";
				break;
			case "music":
				query = query + "and categoryno = 3 ";
				break;
			case "write":
				query = query + "and categoryno = 4 ";
				break;
			case "movie":
				query = query + "and categoryno = 5 ";
				break;
			case "release":
				query = query + "and a.odate > sysdate ";
				break;
			default :
				break;
			}
		}

		List<ProjectVO> list = pdao.getProjectListSerch(query);
		
		int count = list.size();
		
		request.setAttribute("pcount", count);
		request.setAttribute("prolist", list);
	}


}
