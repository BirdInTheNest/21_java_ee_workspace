package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pseq = Integer.parseInt(request.getParameter("seq")); //원글번호
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplyForm.jsp"); //페이지 이동 안하고 body에 뜨도록
		return "/index.jsp";
	}

}
