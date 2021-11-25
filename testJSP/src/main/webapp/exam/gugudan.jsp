<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<% for(int i=1; i<=9; i++){ %>
	<tr>
	<% for(int dan=2; dan<=9; dan++){ %>
		<td width="150" align="center"><%=dan %> * <%=i %> = <%=dan*i  %></td>
	<% }//for dan %>
	</tr>
<% }//for i %>
</table>
</body>
</html>

<!-- 
out.println() 자바 코드 사용하지 않습니다.
웹에서는 자바 코드를 사용하지 않는 추세이기 때문에
<% %> 한 줄씩 적용해야 합니다. 

브라우저에는 tab이 없기 때문에 table을 잡아야 합니다.

----------------------------------------
비즈니스 로직(Java) & 프리젠테이션(Web)

서블릿과 JSP는 자바와 웹을 섞어서 사용하는데,
MVC는 자바와 웹을 따로 따로 사용합니다. 
 -->