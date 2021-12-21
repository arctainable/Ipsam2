package Command.Project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.Command;
import DAO.MemberDAO;
import DAO.ProjectDAO;
import DAO.QnaDAO;
import DAO.RewardDAO;
import DTO.MemberVO;
import DTO.ProjectVO;
import DTO.QnaVO;
import DTO.RewardVO;

public class ProjectViewAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		int sponcount = pdao.getProjectSponCount(pno);
		ProjectVO pvo = pdao.getProjectView(pno);
		
		int likecount = pdao.getProjectLikeCount(pno);
		pvo.setLikecount(likecount);
		
		RewardDAO rdao = RewardDAO.getInstance();
		List<RewardVO> rlist = rdao.getRewardList(pno);
		
		String id = pvo.getId();
		MemberDAO mdao = MemberDAO.getInstance();
		MemberVO mvo = mdao.getMemberLogin(id);

		
		 String pid = pvo.getId(); 
		 String uid = "";
		 HttpSession session = request.getSession();
		 MemberVO User = (MemberVO) session.getAttribute("User");
		 if(User!= null) {
		  uid = User.getId();
		 }
		 System.out.println(pid);
		 System.out.println(uid);
		 List<QnaVO> qlist = null;
		 
		 if(uid != null) {
			 QnaDAO qdao = QnaDAO.getInstance();
			 if(pid.equals(uid)) {
				qlist = qdao.getQnaListAll(pno); 
			 }else{
				qlist = qdao.getQnaListById(uid ,pno);
			 }
		 }
		
		request.setAttribute("pvo", pvo); //프로젝트
		request.setAttribute("sponcount", sponcount); //총 후원자수
		request.setAttribute("rlist", rlist); //프로젝트 리워드 리스트
		request.setAttribute("creator", mvo); //창작자 정보
		request.setAttribute("qlist", qlist); //문의내역
	}

}
