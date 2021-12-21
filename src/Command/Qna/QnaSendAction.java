package Command.Qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import Command.Command;
import DAO.ProjectDAO;
import DAO.QnaDAO;
import DTO.MemberVO;
import DTO.QnaVO;

public class QnaSendAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaVO vo = new QnaVO();
		
		try {
			HttpSession session = request.getSession();
			MemberVO User = (MemberVO) session.getAttribute("User");
			
			if (User == null) {
				response.sendRedirect("login.do");
			} else {
				int pno = Integer.parseInt(request.getParameter("propno"));
				
				vo.setQuestion(request.getParameter("question"));
				vo.setPno(request.getParameter("propno"));
				vo.setId(request.getParameter("writerid"));
				vo.setPid(request.getParameter("proid"));
				
				dao.QnaWrite(vo);
				
				response.sendRedirect("projectview.do?pno="+pno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
