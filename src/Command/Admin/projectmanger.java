package Command.Admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.AdminDAO;
import DTO.PageVO;
import DTO.ProjectVO;
import Util.Criteria;

public class projectmanger implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		AdminDAO adao = AdminDAO.getInstance();
		
		adao.changeProjectStart();
		
	      int pageNum = 1;
	      int amount = 10;
	      
	      if(request.getParameter("pageNum") != null) {
	         pageNum= Integer.parseInt(request.getParameter("pageNum"));
	         amount = Integer.parseInt(request.getParameter("amount"));
	      }
		
		String query ="";
		
		String word= request.getParameter("word");
		
		if( word != null && word != "") {
			query = "like '%"+word+"%'";  
			System.out.println(word);
		}
		

		
		Criteria cri = new Criteria();
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		cri.setKeyword(word);
		
		int count = adao.ProjectListCount(query);
		
		PageVO pvo = null;
		pvo = new PageVO(cri, count);
		
		//ArrayList<ProjectVO> plist = adao.selectProjectList();
		
		String pgrade = request.getParameter("pgrade");
		
		ArrayList<ProjectVO> plist = adao.selectProjectListWithPaging(cri, query);
		
		if(pgrade != null && pgrade !="") {
			switch(pgrade) {
			case "1":
				plist = adao.selectProjectListWithPagingP1(cri, query);
				count = adao.ProjectListCountGrade1(query);
				break;
			case "2":
				plist = adao.selectProjectListWithPagingP2(cri, query);
				count = adao.ProjectListCountGrade2(query);
				break;
			case "3":
				plist = adao.selectProjectListWithPagingP3(cri, query);
				count = adao.ProjectListCountGrade3(query);
				break;
			case "4":
				plist = adao.selectProjectListWithPagingP4(cri, query);
				count = adao.ProjectListCountGrade4(query);
				break;
			}
		}
		
		
		request.setAttribute("plist", plist);
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("count", count);
	}

}
