package board.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB - 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.getBoardList(map);
		
		//세션
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		
		//페이징 처리 클래스 생성
		int totalA = boardDAO.getTotalA();
		
		BoardPaging boardPaging = new BoardPaging(); //클래스 생성
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML(); //메서드 호출
		
		//List -> JSON 변환 { list: [ {변수:값, 변수:값}, {변수:값, 변수:값}, ... ] }
		JSONObject json = new JSONObject(); //제이슨 객체 생성
		if(list != null) {
			JSONArray array = new JSONArray(); //제이슨 배열 생성
			
			for(BoardDTO boardDTO : list) { //리스트의 DTO 하나씩 꺼내서 제이슨 객체 생성
				JSONObject temp = new JSONObject();
				temp.put("seq", boardDTO.getSeq());
				temp.put("id", boardDTO.getId());
				temp.put("name", boardDTO.getName());
				temp.put("email", boardDTO.getEmail());
				temp.put("subject", boardDTO.getSubject());
				temp.put("content", boardDTO.getContent());
				temp.put("ref", boardDTO.getRef());
				temp.put("lev", boardDTO.getLev());
				temp.put("step", boardDTO.getStep());
				temp.put("pseq", boardDTO.getPseq());
				temp.put("reply", boardDTO.getReply());
				temp.put("hit", boardDTO.getHit());
				temp.put("logtime", sdf.format(boardDTO.getLogtime()));
				
				array.add(temp); //제이슨 객체들을 제이슨 배열에 add로 붙인다
			}//for
			
			json.put("list", array); //제이슨 배열을 변수명 list로 제이슨 객체에 put으로 붙인다
		
			//세션 -> JSON 변환
			json.put("memId", memId);
		
		}//if
		
		//BoardPaging -> JSON 변환
//		JSONObject paging = new JSONObject();
//		paging.put("paging", boardPaging.getPagingHTML().toString());
//		json.put("boardPaging", paging);
		
		json.put("boardPaging", boardPaging.getPagingHTML().toString());
		
		System.out.println(json);
		
		request.setAttribute("list", json); //request에 변수명 list로 json 데이터 싣기
		return "/board/getBoardList.jsp";
	}

}
