package Command.Notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import DAO.NoticeDAO;
import DTO.NoticeVO;

public class noticemanger implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		List<NoticeVO> nlist = ndao.selectNoticeList();
		
		request.setAttribute("nlist", nlist);

	}

}
