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
		if(memberDTO == null) {
			return "/member/loginFail.jsp";
		}else {
			//쿠키 - 정보를 가지고 있음
			/*
			Cookie cookie = new Cookie("memName", name); //쿠키 생성 (쿠키명, 값)
			cookie.setMaxAge(30*60); //초 단위, 30분 동안 쿠키가 살아있음
			cookie.setPath("/"); //모든 URL 범위에서 전송, 최상위 경로에서 처리
			response.addCookie(cookie); //클라이언트에게 보내기 -> 웹브라우저로 저장
			
			Cookie cookie2 = new Cookie("memId", id);
			cookie2.setMaxAge(30*60);
			cookie2.setPath("/");
			response.addCookie(cookie2);
			*/
			
			//세션
			HttpSession session = request.getSession(); //세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			session.setAttribute("memDTO", memberDTO); //한번에 DTO 가져가도 됨
			
			//request.setAttribute("name", name); //서블릿의 request에 데이터를 보냄
			//return "/member/loginOk.jsp?name="+name; //주소에 실어 보내는 get방식
			
			return "/member/loginOk.jsp";
		}
	}

}


























