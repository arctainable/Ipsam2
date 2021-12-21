package Command.Main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.EventDAO;
import DAO.ProjectDAO;
import DTO.EventVO;
import DTO.ProjectVO;

public class MainIndexAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		ProjectDAO pdao = ProjectDAO.getInstance();
		
		// 공개예정 4개
		List<ProjectVO> releaseList = pdao.getWaitProjectList();
		request.setAttribute("releList", releaseList);
		
		//새로나온 프로젝트 리스트
		List<ProjectVO> mainList = pdao.getMainProjectList();
		request.setAttribute("mainList", mainList);
		
		//프로젝트 랭킹
		List<ProjectVO> rankList = pdao.getMainRanking();
		request.setAttribute("rankList", rankList);
		
		//이벤트 3개
		EventDAO edao = EventDAO.getInstance();
		List<EventVO> elist = edao.indexlist();
		request.setAttribute("elist", elist);
	}

}
