package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - seq, pg 값 받음
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);		
		
		//return "/board/boardView.jsp"; //화면 이동, 새창 띄움
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
	}

}
