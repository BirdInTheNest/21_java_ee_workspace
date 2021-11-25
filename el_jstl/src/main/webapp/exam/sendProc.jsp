<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//데이터
request.setAttribute("apple", "사과"); //리퀘스트 영역 안에 애플이라는 변수, 사과라는 데이터

//페이지 이동
response.sendRedirect("sendResult.jsp");
%>