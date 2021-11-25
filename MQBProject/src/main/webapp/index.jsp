<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: auto;
}

header {
	width: 1700px;
	height: 10%;
	text-align: center;
}

#container {
	margin: auto;
	width: 1700px;
	height: 500px;
}

#container:after {
	content: '';
	display: block;
	clear: both;
	float: none;
}

nav {
	margin-left: 10px;
	width: 25%;
	height: 100%;
	float: left;
}

section {
	width: 70%;
	height: 100%;
	float: left;
}

footer {
	width: 1700px;
	height: 10%;
}
</style>
</head>
<body>
<header>
	<h1>
		<img alt="오버액션토끼" src="/MQBProject/image/img1.gif" width="100" height="100"
		onclick="location.href='/MQBProject/index.jsp'" style="cursor: pointer;">
		MVC 기반의 미니 프로젝트
	</h1>
	
	<jsp:include page="main/menu.jsp" />
</header>

<div id="container">
	<nav>
		<jsp:include page="main/nav.jsp" />
	</nav>
	
	<section>
		<c:if test="${empty display }">
			<jsp:include page="main/body.jsp" />
		</c:if>
		<c:if test="${not empty display }">
			<jsp:include page="${display }" />
		</c:if>
	</section>
</div>

<footer>
	<p>ALOHA</p>
</footer>

<!-- writeForm, loginForm의 member.js 스크립트 인클루드로 인해 충돌나므로, 최종경로인 index에서만 member.js 부른다 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/member.js"></script>
</body>
</html>