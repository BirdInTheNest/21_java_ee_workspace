<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>    
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.List" %>

<%
//데이터
int pg = Integer.parseInt(request.getParameter("pg"));

//DB
//1페이지당 5개씩
int endNum = pg * 5;
int startNum = endNum - 4;

BoardDAO boardDAO = BoardDAO.getInstance();
List<BoardDTO> list = boardDAO.boardList(startNum, endNum);

//페이징 처리
int totalA = boardDAO.getTotalA();//총글수
int totalP = (totalA + 4) / 5; //총 페이지수

//응답
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th {
	font-size: 16px;
}

td {
	font-size: 13px;
}

#subjectA:link { color: black; text-decoration: none; }
#subjectA:visited { color: black; text-decoration: none; }
#subjectA:hover { color: darkgreen; text-decoration: underline; }
#subjectA:active { color: black; text-decoration: none; }

#currentPaging {
	color: red;
	text-decoration: underline;
}
#paging {
	color: black;
	text-decoration: none;
}

</style>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="100">작성자</th>
		<th width="100">조회수</th>
		<th width="100">작성일</th>
	</tr>
	
	<% if(list!=null){%>
		<% for(BoardDTO boardDTO : list){ %>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td>
					<a href="boardView.jsp?seq=<%=boardDTO.getSeq()%>
					&pg=<%=pg %>" id="subjectA"><%=boardDTO.getSubject() %>
				</td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center"><%=boardDTO.getLogtime() %></td>
			</tr>
		<%}//for %>
	<%}//if %>
</table>
<div style="width: 750px; text-align: center;">
	<%for(int i = 1; i <= totalP; i++) {%>
		<%if(pg==i) {//현재 페이지 %>
			[<a id="currentPaging" href="boardList.jsp?pg=<%=i%>"><%=i %></a>]
		<%}else{ %>
			[<a id="paging" href="boardList.jsp?pg=<%=i%>"><%=i %></a>]
		<%} %>
	<%}//for %>
</div>
</body>
</html>




<!-- 
답글
테이블 같이 사용

댓글(덧글)
테이블 따로 사용

----------------------------------
글번호	제목			그룹번호	단계		글순서	원글번호	답글수
seq		subject		ref		lev		step	pseq	reply



원글 ref = 원글 seq
답글 ref = 원글 ref

원글 lev = 0
답글 lev = 원글 lev + 1

원글 step = 0
답글 step = 원글 step + 1

-------------------------------------
a태그에 CSS 걸 때 오류를 대비하여 한 세트로 네가지를 다 걸어놓는 것이 좋습니다. 
#subjectA:link {}
#subjectA:visited {}
#subjectA:hover {}
#subjectA:active {}

-------------------------------------
http://localhost:8080/boardJSP/board/boardWriteForm.jsp

http://localhost:8080/boardJSP/board/boardWrite.jsp
/boardJSP/board/boardWrite.jsp
boardWrite.jsp
 -->













