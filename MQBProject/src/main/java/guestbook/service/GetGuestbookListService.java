package guestbook.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetGuestbookListService implements CommandProcess {

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
		
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		List<GuestbookDTO> list = guestbookDAO.getGuestbookList(map);
		
		//List -> JSON 변환 { list: [ {변수:값, 변수:값}, {변수:값, 변수:값}, ... ] }
		JSONObject json = new JSONObject(); //제이슨 객체 생성
		if(list != null) {
			JSONArray array = new JSONArray(); //제이슨 배열 생성
			
			for(GuestbookDTO guestbookDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", guestbookDTO.getSeq());
				temp.put("name", guestbookDTO.getName());
				temp.put("email", guestbookDTO.getEmail());
				temp.put("subject", guestbookDTO.getSubject());
				temp.put("content", guestbookDTO.getContent());
				temp.put("logtime", sdf.format(guestbookDTO.getLogtime()));

				array.add(temp); //제이슨 객체들을 제이슨 배열에 add로 붙인다
			}//for
			
			json.put("list", array); //제이슨 배열을 변수명 list로 제이슨 객체에 put으로 붙인다
		
		}//if
		
		System.out.println(json);
		
		request.setAttribute("list", json); //request에 변수명 list로 json 데이터 싣기
		return "/guestbook/getGuestbookList.jsp";
		
	}

}
