package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class ImageboardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - imageboardList.do?pg=1에서 pg 값 받음
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		request.setAttribute("pg", pg); //pg 값 들고 jsp로 이동
		
		//return "/imageboard/imageboardList.jsp"; //단독으로 창이 뜬다. 페이지 이동
		
		request.setAttribute("display", "/imageboard/imageboardList.jsp"); 
		return "/index.jsp";
	}

}
