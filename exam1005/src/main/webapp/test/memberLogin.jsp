<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>    
<%@ page import="member.dao.MemberDAO" %> 

<%
//데이터
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id"); //네임 속성
String pwd = request.getParameter("pwd");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
int sw = memberDAO.memberLogin(id, pwd);

//응답
response.setContentType("text/html; charset=UTF-8");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(sw==0){%>
	<h3>아이디 또는 비밀번호가 맞지 않습니다.</h3>
<%}else if(sw==1){%>
	<h3>로그인 성공</h3>
<%} %>
<input type="button" id="memberLoginBtn" value="로그인" onclick="location.href='memberLoginForm.jsp'">
<input type="button" value="메인" onclick="location.href='main.jsp'">
</body>
</html>