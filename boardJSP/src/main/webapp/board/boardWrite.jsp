<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>

<%
//데이터
request.setCharacterEncoding("UTF-8");

String subject = request.getParameter("subject"); //네임 속성
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setId("hong");
boardDTO.setName("홍길동");
boardDTO.setEmail("hong@java.com");
boardDTO.setSubject(subject);
boardDTO.setContent(content);

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
boardDAO.boardWrite(boardDTO);

//응답
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기 성공</h3>
<br>
<input type="button" id="boardListBtn" value="목록" onclick="location.href='boardList.jsp?pg=1'">
</body>
</html>



<!-- 
boardWriteForm에서 네임 속성 이용하여
<input type="text" name="subject" id="subject" style="width:350px;">

boardWrite.jsp에 데이터 가져온다
String subject = request.getParameter("subject"); //네임 속성
 -->









