package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class GuestbookListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - pg 값 받음
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		request.setAttribute("pg", pg); //pg 값 들고 jsp로 이동
		request.setAttribute("display", "/guestbook/guestbookList.jsp");
		return "/index.jsp";
	}

}
