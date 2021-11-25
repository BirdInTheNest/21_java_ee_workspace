<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String keyword = request.getParameter("keyword");
%>

${param.keyword }

<%-- 
선언문과 자바 코드는 웹으로 끌고 가지 않습니다.
남은 값들 전부 가지고 가기 때문에 핵심만 빼고 지웁니다.

자바코드로 표현한
String keyword = request.getParameter("keyword"); 와

${param.keyword } 는 같은 값을 의미합니다. 
--%>