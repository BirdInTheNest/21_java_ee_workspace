package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - boardList.do?pg=1에서 pg 값 받음
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		request.setAttribute("pg", pg); //pg 값 들고 jsp로 이동
		request.setAttribute("display", "/board/boardList.jsp");
		return "/index.jsp";
	}

}
