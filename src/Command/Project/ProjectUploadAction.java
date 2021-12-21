package Command.Project;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Command.Command;
import DAO.ProjectDAO;
import DAO.RewardDAO;
import DTO.ProjectVO;
import DTO.RewardVO;

public class ProjectUploadAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			HttpSession session = request.getSession();
			
			int sizeLimit = 5 * 1024 * 1024;
			String savePath = "projectupload";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			
			MultipartRequest multi;
			multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			

			ProjectVO pvo = new ProjectVO();
			
			pvo.setPname2(multi.getParameter("title")); // 프로젝트 제목
			pvo.setPcontent1(multi.getParameter("p_intro")); //프로젝트 소개글
			pvo.setPcontent2(multi.getParameter("content2")); //프로젝트 내용
			pvo.setPcontent3(multi.getParameter("pcontent3")); //창작자 소개
			pvo.setOdate(multi.getParameter("start_date")); //신청 날짜
			pvo.setGdate(multi.getParameter("goal_date")); //공개 날짜
			pvo.setPmoney(Integer.parseInt(multi.getParameter("g_price"))); //목표금액
			pvo.setId(multi.getParameter("writer")); //창작자아이디
			pvo.setCategoryno(Integer.parseInt(multi.getParameter("Category"))); //카테고리번호
			String bank = multi.getParameter("bank_name"); //은행
			String account = multi.getParameter("account_num"); //계좌번호
			pvo.setPaccount(bank+" : "+account); // 은행 + 계좌번호
			
			
			String image = multi.getFilesystemName("pname1"); //썸네일
			
			pvo.setPname1(image);
			
			ProjectDAO pdao = ProjectDAO.getInstance();
			int result = pdao.setProjectInsert(pvo);
			
			if(result > 0) {
				RewardDAO rdao = RewardDAO.getInstance();
				
				RewardVO rvo1 = new RewardVO();
				rvo1.setPno(result);
				rvo1.setRno(1);
				rvo1.setRcontent(multi.getParameter("reward_c1"));
				rvo1.setRmoney(Integer.parseInt(multi.getParameter("reward_p1")));
				rdao.setRewardInsert(rvo1);
				
				RewardVO rvo2 = new RewardVO();
				rvo2.setPno(result);
				rvo2.setRno(2);
				rvo2.setRcontent(multi.getParameter("reward_c2"));
				rvo2.setRmoney(Integer.parseInt(multi.getParameter("reward_p2")));
				rdao.setRewardInsert(rvo2);
				
				RewardVO rvo3 = new RewardVO();
				rvo3.setPno(result);
				rvo3.setRno(3);
				rvo3.setRcontent(multi.getParameter("reward_c3"));
				rvo3.setRmoney(Integer.parseInt(multi.getParameter("reward_p3")));
				rdao.setRewardInsert(rvo3);
				
				response.sendRedirect("applycomplete.do");//성공페이지
			}else {
				session.setAttribute("message", "업로드를 실패 했습니다");
				response.sendRedirect("applywrite.do"); //다시 입력페이지
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
