package product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class ProductListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - productList.do?pg=1에서 pg 값 받음
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		request.setAttribute("pg", pg); //pg 값 들고 jsp로 이동
		request.setAttribute("display", "/product/productList.jsp"); 
		return "/index.jsp";
	}

}
