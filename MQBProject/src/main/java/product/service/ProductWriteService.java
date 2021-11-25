package product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;

import product.bean.ProductDTO;
import product.dao.ProductDAO;

public class ProductWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제폴더 D:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MQBProject\storage
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		
		//업로드
		MultipartRequest multi = new MultipartRequest(request
													, realFolder
													, 5*1024*1024 //5MB 최대용량
													, "UTF-8");
		
		//데이터 - 업로드하면 데이터를 불러오는 모든 권한이 HttpServletRequest에서 MultipartRequest로 변한다
		String img = multi.getOriginalFileName("img"); //원본 파일명
		String name = multi.getParameter("name");
		int unit = Integer.parseInt(multi.getParameter("unit"));
		int qty = Integer.parseInt(multi.getParameter("qty"));
		double rate = Double.parseDouble(multi.getParameter("rate"));
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setImg(img); //파일명만 싣는다
		productDTO.setName(name);
		productDTO.setUnit(unit);
		productDTO.setQty(qty);
		productDTO.setRate(rate);

		//DB
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.productWrite(productDTO);
		
		//응답
		request.setAttribute("display", "/product/productWrite.jsp");
		return "/index.jsp";
	}

}
