<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//데이터 꺼내오기 - forward방식이라 데이터 공유됨 
//Proc의 request가 전체페이지 관리하므로, Result의 request는 죽음
String apple = (String)request.getAttribute("apple");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 = <%=apple %>
</body>
</html>