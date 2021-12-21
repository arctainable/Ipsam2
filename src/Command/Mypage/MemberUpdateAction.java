package Command.Mypage;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Command.Command;
import DAO.MemberDAO;
import DTO.MemberVO;
import DTO.MypageVO;
import Util.Utility;

public class MemberUpdateAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "memberprofile";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

//		System.out.println(uploadFilePath);

		MultipartRequest multi;
		MemberVO memberVO = new MemberVO();
		try {
			multi = new MultipartRequest(request, // 1. 요청 객체
					uploadFilePath, // 2. 업로드될 파일이 저장될 파일 경로명
					sizeLimit, // 3. 업로드될 파일의 최대 크기(5Mb)
					"UTF-8", // 4. 인코딩 타입 지정
					new DefaultFileRenamePolicy() // 5. 덮어쓰기를 방지 위한 부분
			);
			System.out.println("pw값은 "+multi.getParameter("pw"));
			System.out.println("pw3값은 "+multi.getParameter("pw3"));
			memberVO.setBno(Integer.parseInt(multi.getParameter("bno")));
			memberVO.setId(multi.getParameter("id"));
			memberVO.setName(multi.getParameter("name"));
			memberVO.setPw(Utility.encoding(multi.getParameter("pw")));
			memberVO.setEmail(multi.getParameter("email"));
			memberVO.setGrade(Integer.parseInt(multi.getParameter("grade")));
			
			if (multi.getFilesystemName("profile") != null) {
				memberVO.setProfile(multi.getFilesystemName("profile"));
			} else {
				memberVO.setProfile(multi.getParameter("profile2"));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 이 시점을 기해 파일은 이미 저장이 되었다

		session.setAttribute("User", memberVO);

		MemberDAO.setMemberUpdate(memberVO);

	}

}
