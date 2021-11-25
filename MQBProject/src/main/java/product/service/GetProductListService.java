package product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import product.bean.ProductDTO;
import product.dao.ProductDAO;

public class GetProductListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB - 1페이지당 3개씩
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ProductDAO productDAO = ProductDAO.getInstance();
		List<ProductDTO> list = productDAO.getProductList(map);
		
		//응답 List -> JSON 변환 { list: [ {변수:값, 변수:값}, {변수:값, 변수:값}, ... ] }
		JSONObject json = new JSONObject(); //제이슨 객체 생성 {}
		if(list != null) {
			JSONArray array = new JSONArray(); //제이슨 배열 생성 { array: [] }
			
			for(ProductDTO productDTO : list) { //리스트의 DTO 하나씩 꺼내서 제이슨 객체 생성 { array: [ {},{},{} ] }
				JSONObject temp = new JSONObject();
				temp.put("seq", productDTO.getSeq());
				temp.put("img", productDTO.getImg());
				temp.put("name", productDTO.getName());
				temp.put("unit", productDTO.getUnit());
				temp.put("qty", productDTO.getQty());
				temp.put("total", productDTO.getTotal());
				temp.put("rate", productDTO.getRate());
				temp.put("discount", productDTO.getDiscount());
				temp.put("price", productDTO.getPrice());
				
				array.add(temp); //제이슨 객체들을 제이슨 배열에 add로 붙인다
			}//for
				
			json.put("list", array); //제이슨 배열을 변수명 list로 제이슨 객체에 put으로 붙인다

		}//if

		System.out.println(json);
		
		request.setAttribute("list", json); //request에 변수명 list로 json 데이터 싣기
		return "/product/getProductList.jsp";
	}

}
