package Command.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Command.Command;

public class EmailOkAction implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
			String certinumber = request.getParameter("certinumber");
			
			System.out.println("1"+certinumber);
			System.out.println("2"+AuthenticationKey);
			
			JSONObject obj = new JSONObject();
			
			if(!AuthenticationKey.equals(certinumber)) {
				obj.put("msg", "다시 인증하세요");
				obj.put("check","nok");
			}else {
				obj.put("msg", "인증 완료하셨습니다");
				obj.put("check", "ok");
			}
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json; charest-utf-8");
			response.getWriter().print(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
