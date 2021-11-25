<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	color: red;
	font-size: 0.8em;
	font-weight: bold;
}
body {
	margin: 0 auto;
	width: 400px;
	background: aliceblue;
}
body h1 {
	text-align: center;
	margin: 10px;
}
body p{
	margin: 10px;
}
ul li {
	margin: 10px;
}
table {
	margin: 0 auto;
	border-collapse: collapse;
	cellspacing: 0;
	cellpadding: 5px;
}
table td {
	height: 15px;
}
table div {
	color: red;
	font-size: 0.7em;
	font-weight: bold;
}
table tr {
	border: 1px solid gray;
	text-align: justify;
	width: 50px; 
	height: 20px; 
}
h3.title {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
<form name="memberLoginForm" method="post" action="memberLogin.jsp">
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">아이디</td>
			<td>
				<input type="text" name="id" id="id" placeholder="아이디 입력">
				<div id= "idDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">비밀번호</td>
			<td>
				<input type="password" name="pwd" id="pwd" size="30" placeholder="비밀번호 입력">
				<div id= "pwdDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="memberLoginBtn" value="로그인">
				<input type="button" value="메인" onclick="location.href='main.jsp'">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</body>
</html>