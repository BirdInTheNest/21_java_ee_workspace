package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 - 체크박스에서 선택한 값들만 네임 속성으로 넘어온다
		String[] check = request.getParameterValues("check");
		
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardDelete(check);
		
		//응답
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		return "/index.jsp";
	}

}
