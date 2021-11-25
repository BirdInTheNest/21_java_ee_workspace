<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//데이터
request.setAttribute("apple", "사과"); //리퀘스트 영역 안에 애플이라는 변수, 사과라는 데이터

//페이지 이동 forward
%>
<!-- <jsp:forward page="forwardResult.jsp" /> -->

<%
//페이지 이동 forward와 같은 의미 - RequestDispatcher 상대번지만 사용해야함
RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); 
dispatcher.forward(request, response); 
//제어권을 forwardResult.jsp에 넘기기, request 통합됨
%>