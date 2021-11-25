<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.memId == null }">
	<jsp:include page="../member/loginForm.jsp" />
</c:if>

<c:if test="${memId != null }">
	<jsp:include page="../member/loginOk.jsp" />
</c:if>


<!-- 
sessionScope.memId에서
sessionScope 생략하고 memId만 써도, 
JSP는 내 자신의 위치인 page부터 내장객체 순서대로 ﻿찾습니다.
JSTL은 내 자신의 위치인 pageScope부터 내장객체 순서대로 ﻿찾습니다.

JSP			JSTL
page		pageScope
request		requestScope
session		sessionScope

 -->