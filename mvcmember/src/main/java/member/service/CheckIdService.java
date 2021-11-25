package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - 네임 속성으로 가져온다
		String id = request.getParameter("id");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤, 1번 생성해서 계속 사용
		boolean exist = memberDAO.isCheckId(id);
				
		//응답
		request.setAttribute("id", id);
		
		if(exist) //아이디가 있으면 T
			return "/member/checkIdFail.jsp"; //사용 불가능
		else
			return "/member/checkIdOk.jsp"; //사용 가능
		
	}

}











