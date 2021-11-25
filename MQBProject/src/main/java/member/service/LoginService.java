package member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - 네임 속성으로 가져온다
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		
		//응답
		if(memberDTO != null) {
			//세션
			HttpSession session = request.getSession(); //세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			session.setAttribute("memDTO", memberDTO); //한번에 DTO 가져가도 됨
			
			//request.setAttribute("name", name); //서블릿의 request에 데이터를 보냄
			//return "/member/loginOk.jsp?name="+name; //주소에 실어 보내는 get방식
		}
		
		return "/member/login.jsp";
	}

}