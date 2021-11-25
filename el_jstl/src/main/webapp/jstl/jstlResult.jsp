<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<fmt:requestEncoding value="UTF-8" /> <!-- request.setCharacterEncoding("UTF-8") -->
<!-- get방식일 때는 안 해도 됩니다. post방식일 때만 한글 처리 합니다. -->

<style type="text/css">
ul li {
	color: ${param.color};
}
</style>
</head>
<body>
<ul>
	<li>이 름 : ${param.name } </li><br>
	
	<li>나 이 : ${param.age }
	<c:if test="${param.age >= 19 }"> <!-- if test="조건" -->
		<strong>성인</strong>
	</c:if>
	
	<c:if test="${param.age < 19 }"> <!-- else if가 없기 때문에 if로 해야함 -->
		<strong>청소년</strong>
	</c:if>
	</li><br>
	
	<li>색 깔 : 
		<c:if test="${param.color == 'red'}"><strong>빨강</strong></c:if>
		<c:if test="${param.color == 'green'}"><strong>초록</strong></c:if>
		<c:if test="${param.color == 'blue'}"><strong>파랑</strong></c:if>
		<c:if test="${param.color == 'vioet'}"><strong>보라</strong></c:if>
		<c:if test="${param.color == 'cyan'}"><strong>하늘</strong></c:if>
	</li><br>
	
	<li>취 미 :
		${paramValues['hobby'][0] } <!-- ${paramValues.hobby[0] } -->
		${paramValues['hobby'][1] }
		${paramValues['hobby'][2] }
		${paramValues['hobby'][3] }
		${paramValues['hobby'][4] }
	</li><br>
	
	<li>취 미 :
		<br>
		<c:forEach var="data" items="${paramValues.hobby }" varStatus="i">
			인덱스 = ${i.index } &emsp; 개수 = ${i.count } &emsp; ${data } <br>
			<!-- 인덱스는 checkbox에서 체크한 값들만을 가지고 부여합니다 -->
		</c:forEach>
	</li><br>
</ul>
</body>
</html>






















