package imageboard.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetImageboardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB - 1페이지당 3개씩
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		List<ImageboardDTO> list = imageboardDAO.getImageboardList(map);
		
		//세션
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		
		//페이징 처리 클래스 생성
		int totalA = imageboardDAO.getImageboardTotalA(); //총글수
		
		//BoardPaging 클래스를 공통 폴더에서 같이 사용하거나, BoardPaging, ImageboardPaging 따로 만들거나
		ImageboardPaging imageboardPaging = new ImageboardPaging(); //클래스 생성
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3); //[][][]
		imageboardPaging.setPageSize(3); //1페이지당 3개씩
		imageboardPaging.setTotalA(totalA); //총글수
		imageboardPaging.makePagingHTML(); //메소드 호출
		
		//응답 List -> JSON 변환 { list: [ {변수:값, 변수:값}, {변수:값, 변수:값}, ... ] }
		JSONObject json = new JSONObject(); //제이슨 객체 생성 {}
		if(list != null) {
			JSONArray array = new JSONArray(); //제이슨 배열 생성 { array: [] }
			
			for(ImageboardDTO imageboardDTO : list) { //리스트의 DTO 하나씩 꺼내서 제이슨 객체 생성 { array: [ {},{},{} ] }
				JSONObject temp = new JSONObject();
				temp.put("seq", imageboardDTO.getSeq());
				temp.put("imageId", imageboardDTO.getImageId());
				temp.put("imageName", imageboardDTO.getImageName());
				temp.put("imagePrice", imageboardDTO.getImagePrice());
				temp.put("imageQty", imageboardDTO.getImageQty());
				temp.put("imageContent", imageboardDTO.getImageContent());
				temp.put("image1", imageboardDTO.getImage1());
				temp.put("logtime", sdf.format(imageboardDTO.getLogtime()));
				
				array.add(temp); //제이슨 객체들을 제이슨 배열에 add로 붙인다
			}//for
				
			json.put("list", array); //제이슨 배열을 변수명 list로 제이슨 객체에 put으로 붙인다
			
			//세션 -> JSON 변환
			json.put("memId", memId);
			
		}//if
					
		json.put("imageboardPaging", imageboardPaging.getPagingHTML().toString());
		
		System.out.println(json);
		
		request.setAttribute("list", json); //request에 변수명 list로 json 데이터 싣기
		return "/imageboard/getImageboardList.jsp";
	}

}
