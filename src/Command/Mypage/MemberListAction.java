package Command.Mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.MemberDAO;
import DAO.MypageDAO;
import DTO.MypageVO;
import DTO.PageMyVO;
import DTO.ProjectVO;
import DTO.SponsorVO;
import Util.CriteriaMy;

public class MemberListAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 3;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		MypageDAO mdao = MypageDAO.getInstance();
		List<MypageVO> list = mdao.getMemberProjectListWithPaging1(cri, id);
	
		System.out.println(list);

		
		int count1 = mdao.getCount1(id);
		int count2 = mdao.getCount2(id);
		int count3 = mdao.getCount3(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, count1);
		
		request.setAttribute("list", list);
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
		request.setAttribute("count3", count3);
		request.setAttribute("pagemaker", pagevo);
		
	}

	public void excute2(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 3;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		MypageDAO mdao = MypageDAO.getInstance();
		List<ProjectVO> list = mdao.getMemberProjectListWithPaging2(cri, id);
	
		System.out.println(list);

		
		int count1 = mdao.getCount1(id);
		int count2 = mdao.getCount2(id);
		int count3 = mdao.getCount3(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, count1);
		
		request.setAttribute("list", list);
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
		request.setAttribute("count3", count3);
		request.setAttribute("pagemaker", pagevo);
		
	}
	
	public void excute3(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 3;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		MypageDAO pdao = MypageDAO.getInstance();
		List<ProjectVO> list = pdao.getMemberProjectListWithPaging3(cri, id);
		int count1 = pdao.getCount1(id);
		int count2 = pdao.getCount2(id);
		int count3 = pdao.getCount3(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, count1);
		
		request.setAttribute("list", list);
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
		request.setAttribute("count3", count3);
		request.setAttribute("pagemaker", pagevo);
		
	}

	public void excute4(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 3;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		MypageDAO mdao = MypageDAO.getInstance();
		
		List<MypageVO> list = mdao.getMemberProjectListWithPaging4(cri, id);
			
//		String dname = request.getParameter("pname1");
//		System.out.println(dname);
		
		int count4 = mdao.getCount4(id);
		int count5 = mdao.getCount5(id);
		int countnews = mdao.getMypageNewsCount(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, count4);
		
		request.setAttribute("list", list);
		request.setAttribute("count4", count4);
		request.setAttribute("count5", count5);
		request.setAttribute("countnews", countnews);
		request.setAttribute("pagemaker", pagevo);
		
	}
	
	public void excute5(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 3;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		MypageDAO mdao = MypageDAO.getInstance();
		
		List<MypageVO> list = mdao.getMemberProjectListWithPaging5(cri, id);
			
//		String dname = request.getParameter("pname1");
//		System.out.println(dname);
		
		int count4 = mdao.getCount4(id);
		int count5 = mdao.getCount5(id);
		int countnews = mdao.getMypageNewsCount(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, count5);
		
		request.setAttribute("list", list);
		request.setAttribute("count4", count4);
		request.setAttribute("count5", count5);
		request.setAttribute("countnews", countnews);
		request.setAttribute("pagemaker", pagevo);
		
	}
	
	public void excute6(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pageNum = 1;
		int amount = 6;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		MypageDAO mdao = MypageDAO.getInstance();
		List<MypageVO> list = mdao.getMemberProjectListWithPaging6(cri, id);
		
		int count4 = mdao.getCount4(id);
		int count5 = mdao.getCount5(id);
		int countnews = mdao.getMypageNewsCount(id);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, countnews);
		
		request.setAttribute("list", list);
		request.setAttribute("count4", count4);
		request.setAttribute("count5", count5);
		request.setAttribute("countnews", countnews);
		request.setAttribute("pagemaker", pagevo);
		
	}
	
	public void excute7(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pname2 = request.getParameter("pname2");
		
		int pageNum = 1;
		int amount = 11;
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		CriteriaMy cri = new CriteriaMy();
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		MypageDAO pdao = MypageDAO.getInstance();
		List<MypageVO> list = pdao.getSponsorListWithPaging(cri, pno);
		int count1 = pdao.getCount1(id);
		int count2 = pdao.getCount2(id);
		int count3 = pdao.getCount3(id);
		int scount = pdao.getsponsorcount(cri, pno);
		
		PageMyVO pagevo = null;
		
		pagevo = new PageMyVO(cri, scount);
		
		request.setAttribute("list", list);
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
		request.setAttribute("count3", count3);
		request.setAttribute("scount", scount);
		request.setAttribute("pagemaker", pagevo);
		request.setAttribute("pno", pno);
		request.setAttribute("pname2", pname2);
	}
	
	public void excuteupdatereward(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		SponsorVO svo = new SponsorVO();
		
		svo.setId(request.getParameter("id"));
		svo.setPno(Integer.parseInt(request.getParameter("pno")));
		svo.setSgrade(Integer.parseInt(request.getParameter("sgrade")));

		MypageDAO.updatesponsorsdate(svo);
	}
}
