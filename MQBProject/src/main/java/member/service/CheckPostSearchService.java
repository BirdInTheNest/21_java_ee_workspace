package member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CheckPostSearchService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		System.out.println(sido + ", " + sigungu + ", " + roadname);
		
		//DB
		List<ZipcodeDTO> list = null;
		if(sido != null && roadname != null) {
			MemberDAO memberDAO = MemberDAO.getInstance();
			list = memberDAO.getZipcodeList(sido, sigungu, roadname);
			System.out.println("list="+list); //list의 주소값 [~~,~~,~~]
		}
		
		//list를 JSON으로 변환 { list: [ {'zipcode':'12345', 'sido':'서울', 'sigungu':'강남', ~~} ] }
		JSONObject json = new JSONObject(); //제이슨 객체
		if(list != null) {
			JSONArray array = new JSONArray(); //제이슨 배열

//			list에 담긴 dto들을 하나씩 꺼내고, json객체에 그 dto의 값을 꺼내서 넣는다
//			for(int i=0; i<list.size(); i++) {
//				ZipcodeDTO zipcodeDTO = list.get(i); //인덱스 번호로 list 값 하나씩 꺼낸다
			
			for(ZipcodeDTO zipcodeDTO : list) {	//배열 안에 들어갈 제이슨 객체 for문 돌려서 생성
				JSONObject temp = new JSONObject(); //제이슨 객체
				temp.put("zipcode", zipcodeDTO.getZipcode());
				temp.put("sido", zipcodeDTO.getSido());
				temp.put("sigungu", zipcodeDTO.getSigungu());
				temp.put("yubmyundong", zipcodeDTO.getYubmyundong());
				temp.put("ri", zipcodeDTO.getRi());
				temp.put("roadname", zipcodeDTO.getRoadname());
				temp.put("buildingname", zipcodeDTO.getBuildingname());
				
//				array.add(i, temp);
				array.add(temp); //제이슨 배열 안에 제이슨 객체 add로 붙인다
			}//for
			
			json.put("list", array); //제이슨 객체에 리스트란 이름으로 제이슨 배열 put으로 붙인다
		}
		
		System.out.println("json =" + json);
		
		//응답
		request.setAttribute("list", json); //변수명 list로 json 보내기
		return "/member/checkPostSearch.jsp";
	}

}
