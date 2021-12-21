package Command.Qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.QnaDAO;
import DTO.QnaVO;

public class ReplyAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		QnaDAO dao = QnaDAO.getInstance();
		QnaVO vo = new QnaVO();
		int bno = Integer.parseInt(request.getParameter("qno"));
		
		try {
			
			vo.setBno(bno);
			vo.setReply(request.getParameter("rp"));
			
			dao.replywrite(vo);
			int pno = Integer.parseInt(request.getParameter("pno"));
			response.sendRedirect("projectview.do?pno="+pno);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
