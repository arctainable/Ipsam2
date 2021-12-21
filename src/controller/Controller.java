package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Admin.Allprojectcount;
import Command.Admin.GradeModify;
import Command.Admin.MemberManager;
import Command.Admin.MemberSelect;
import Command.Admin.adminprojectview;
import Command.Admin.projectchange;
import Command.Admin.projectmanger;
import Command.Event.eventadminview;
import Command.Event.eventdelete;
import Command.Event.eventmanger;
import Command.Event.eventview;
import Command.Event.eventwritePro;
import Command.Main.MainIndexAction;
import Command.Member.JoinAction;
import Command.Member.LoginAction;
import Command.Member.LogoutAction;
import Command.Mypage.MemberListAction;
import Command.Mypage.MemberUpdateAction;
import Command.News.NewsDeleteAction;
import Command.News.NewsListAction;
import Command.News.NewsModifyAction;
import Command.News.NewsViewAction;
import Command.News.NewsWriteAction;
import Command.News.NewsWriteProAction;
import Command.News_Comment.CommentDeleteAction;
import Command.News_Comment.CommentInsertAction;
import Command.Notice.notice;
import Command.Notice.noticeadminview;
import Command.Notice.noticedelete;
import Command.Notice.noticemanger;
import Command.Notice.noticeview;
import Command.Notice.noticewritepro;
import Command.Project.ApplyWriteAction;
import Command.Project.EmailCheckAction;
import Command.Project.EmailOkAction;
import Command.Project.LikeAction;
import Command.Project.ListAction;
import Command.Project.ProjectDeleteAction;
import Command.Project.ProjectUploadAction;
import Command.Project.ProjectViewAction;
import Command.Project.ReleaseViewAction;
import Command.Qna.QnaSendAction;
import Command.Qna.ReplyAction;
import Command.Reward.RewardReadyAction;
import Command.Sponsor.SponAction;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String uri = request.getRequestURI(); //uri요청, 페이지에서 가려고 하는곳
		String conPath = request.getContextPath(); // ContextPath=프로젝트이름, 잘라줄 path 잡고 
		String com = uri.substring(conPath.length()); // uri에서 path로 잘라서 /~~~.do 로 만든다

		String viewPage = null; // 보내줄 페이지
		
		switch(com) {
		case "/main.do":
			new MainIndexAction().excute(request, response);
			viewPage = "index.jsp";
			break;
		case "/project.do":
			new ListAction().excute(request, response);
			viewPage = "project/projectlist.jsp";
			break;
		case "/join.do":
			viewPage = "member/join.jsp";
			break;
		case "/login.do":
			viewPage = "login/login.jsp";
			break;
		case "/joinpro.do":
			new JoinAction().excute(request, response);
			break;
		case "/loginpro.do":
			new LoginAction().excute(request, response);
			break;
		case "/logout.do":
			new LogoutAction().excute(request, response);
			response.sendRedirect("main.do");
			break;
		case "/projectview.do":
			new ProjectViewAction().excute(request, response);
			viewPage = "project/projectview.jsp";
			break;
		case "/apply.do":
			viewPage = "write/apply.jsp";
			break;
		case "/community.do":
			new ProjectViewAction().excute(request, response);
			new NewsListAction().excute(request, response);
			viewPage = "project/projectcommunity.jsp";
			break;
		case "/applywrite.do": //로그인 안한사람 로그인하게
			new ApplyWriteAction().excute(request, response);
			break;
		case "/projectupload.do":
			new ProjectUploadAction().excute(request, response);
			break;
		case "/applycomplete.do":
			viewPage = "write/apply_write_complete.jsp";
			break;
		case "/mypage.do":
			new MemberListAction().excute4(request, response);
			viewPage = "mypage/mypage.jsp";
			break;
		case "/mypage2.do":
			new MemberListAction().excute5(request, response);
			viewPage = "mypage/mypage2.jsp";
			break;
		case "/News.do":
			new MemberListAction().excute6(request, response);
			viewPage = "mypage/News.jsp";
			break;
		case "/myproject.do":
			new MemberListAction().excute(request, response);
			viewPage = "mypage/myproject.jsp";
			break;
		case "/myproject2.do":
			new MemberListAction().excute2(request, response);
			viewPage = "mypage/myproject2.jsp";
			break;	
		case "/myproject3.do":
			new MemberListAction().excute3(request, response);
			viewPage = "mypage/myproject3.jsp";
			break;	
		case "/sponsorlist.do":
			new MemberListAction().excute7(request, response);
			viewPage = "mypage/sponsorlist.jsp";
			break;
		case "/sponsormodify.do":
			new MemberListAction().excuteupdatereward(request, response);
			viewPage="sponsorlist.do";
			break;	
		case "/profile.do":
			viewPage = "mypage/profile.jsp";
			break;
		case "/profile_write.do":
			new MemberUpdateAction().excute(request, response);
			response.sendRedirect("profile.do");
			break;
		case "/notice.do":
			new notice().excute(request, response);
			viewPage = "notice/notice.jsp";
			break;
		case "/noticeview.do":
			new noticeview().excute(request, response);
			viewPage = "notice/noticeview.jsp";
			break;
		case "/introduce.do":
			new notice().excute(request, response);
			viewPage = "notice/introduce.jsp";
			break;
		case "/event.do":
			new notice().excute(request, response);
			viewPage = "notice/event.jsp";
			break;
		case "/eventview.do":
			new eventview().excute(request, response);
			viewPage = "notice/eventview.jsp";
			break;
		case "/faq.do":
			new notice().excute(request, response);
			viewPage = "notice/faq.jsp";
			break;
			
			//난주 시작	
		case "/admin.do": //관리자 페이지
			new Allprojectcount().excute(request, response);
			viewPage = "admin/admin.jsp";
			break;
		case "/member-manger.do": //회원관리(리스트)//난주
			new MemberSelect().excute(request, response);
			viewPage = "admin/member-manger.jsp";
			break;
		case "/admin-member-view.do": //회원 관리 상세페이지//난주
			new MemberManager().excute(request, response);
			viewPage = "admin/admin-member-view.jsp";
			break;
		case "/grade_modify.do": //회원등급관리//난주
			new GradeModify().excute(request, response);
			response.sendRedirect("member-manger.do");
			break;
			
			//지영	
		case "/project-manger.do": 
			new projectmanger().excute(request, response);
			viewPage = "admin/project-manger.jsp";
			break;
		case "/admin-project-view.do":
			new adminprojectview().excute(request, response);
			viewPage = "admin/admin-project-view.jsp";
			break;
		case "/projectchange.do":
			new projectchange().excute(request, response);
			response.sendRedirect("project-manger.do");
			break;
		case "/notice-manger.do":
			new noticemanger().excute(request, response);
			viewPage = "admin/notice-manger.jsp";
			break;	
		case "/event-manger.do": 
			new eventmanger().excute(request, response);
			viewPage = "admin/event-manger.jsp";
			break;
		case "/noticewrite.do": 
			viewPage = "admin/notice-write.jsp";
			break;
		case "/noticewritePro.do": 
			new noticewritepro().excute(request, response);
			response.sendRedirect("notice-manger.do");
			break;
		case "/noticeadminview.do":
			new noticeadminview().excute(request, response);
			viewPage = "admin/notice-view.jsp";
			break;
		case "/noticedelete.do":
			new noticedelete().excute(request, response);
			response.sendRedirect("notice-manger.do");
			break;
		case "/eventwrite.do": 
			viewPage = "admin/event-write.jsp";
			break;
		case "/eventwritePro.do": 
			new eventwritePro().excute(request, response);
			response.sendRedirect("event-manger.do");
			break;
		case "/eventadminview.do": 
			new eventadminview().excute(request, response);
			viewPage = "admin/event-view.jsp";
			break;
		case "/eventdelete.do":
			new eventdelete().excute(request, response);
			response.sendRedirect("event-manger.do");
			break;
			//지영
			
			//백승국 
		case "/project-order.do":
			new RewardReadyAction().excute(request, response);
			break;
		case "/projectspon.do":
			new SponAction().excute(request, response);
			break;
		case "/projectnewswrite.do":
			new ProjectViewAction().excute(request, response);
			new NewsWriteAction().excute(request, response);
			break;
		case "/projectnewswritepro.do":
			new NewsWriteProAction().excute(request, response);
			break;
		case "/project-community-view.do":
			new ProjectViewAction().excute(request, response);
			new NewsViewAction().excute(request, response);
			viewPage = "project/project-community-view.jsp";
			break;
		case "/newsModify.do":
			new ProjectViewAction().excute(request, response);
			new NewsViewAction().excute(request, response);
			viewPage="project/project-community-modify.jsp";
			break;
		case "/newsDelete.do":
			new NewsDeleteAction().excute(request, response);
			break;
		case "/newsmodifypro.do":
			new NewsModifyAction().excute(request, response);
			break;
		case "/projectrelease.do":
			new ReleaseViewAction().excute(request, response);
			viewPage = "project/project-release.jsp";
			break;
		case "/projectLike.do":
			new LikeAction().excute(request, response);
			break;
		case "/emailcheck.do":
			new EmailCheckAction().excute(request, response);
			break;
		case "/certicompare.do":
			new EmailOkAction().excute(request, response);
			break;
		case "/commentinsert.do":
			new CommentInsertAction().excute(request, response);
			break;
		case "/commentdelete.do":
			new CommentDeleteAction().excute(request, response);
			break;
		case "/projectdelete.do":
			new ProjectDeleteAction().excute(request, response);
			break;
			//백승국
		
			//김원주
		case "/qnawrite.do":
			new QnaSendAction().excute(request, response);
			break;
		case "/replywrite.do":
			new ReplyAction().excute(request, response);
			break;
		}
		
		if(viewPage != null) { //viewPage가 널과 같지 않으면 = ~~.do로 갈려고 하는 페이지가 있으면
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response); // 슛~
		}
	}
}
