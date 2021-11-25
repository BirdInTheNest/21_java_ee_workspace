<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>    
    
<%
//데이터
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id"); //네임 속성
String pwd = request.getParameter("pwd");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");

MemberDTO memberDTO = new MemberDTO();
memberDTO.setId(id);
memberDTO.setPwd(pwd);
memberDTO.setEmail1(email1);
memberDTO.setEmail2(email2);

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
memberDAO.memberWrite(memberDTO);

//응답
response.setContentType("text.html; charset=UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입 성공</h3>
<br>
<input type="button" id="memberLoginBtn" value="로그인" onclick="location.href='memberLoginForm.jsp'">
<input type="button" value="메인" onclick="location.href='main.jsp'">
</body>
</html>