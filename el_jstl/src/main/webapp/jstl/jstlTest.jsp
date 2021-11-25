<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** 변수 설정 **</h3>
<c:set var="name" value="홍길동"></c:set>
<c:set var="age">25</c:set>

나의 이름은 ${name } 입니다. <br>
내 나이는 <c:out value="${age }"></c:out>살 입니다<br>
나의 키는 ${height } 입니다.

<h3>** 변수 삭제 **</h3>
<c:remove var="name"/>

나의 이름은 ${name } 입니다. <br>
내 나이는 <c:out value="${age }"></c:out>살 입니다<br>
나의 키는 ${height } 입니다.

<h3>** forEach **</h3>
<c:forEach var="i" begin="1" end="10" step="1"> <%-- for(int i=1; i<=10; i++) --%>
	${i }
	<c:set var="sum" value="${sum + i }"></c:set> <%-- sum = sum + i --%>
</c:forEach>
<br>
1 ~ 10 까지의 합 ${sum } 입니다.
<br><br>

<c:forEach var="i" begin="1" end="10" step="1">
	${11-i }
</c:forEach>
<br>

<h3>** 문자열 분리 **</h3>
<c:forTokens var="car" items="소나타,아우디,링컨,페라리,벤츠" delims=",">
	${car }<br>
</c:forTokens>

<h3>** jstlExam.jsp에서 넘어오는 데이터 **</h3>
${requestScope.list } <!-- 결과창에 []로 리스트의 주소값을 나타냄 -->
<!-- 자바코드에서 request.getAttribute("list")와 같음 -->

<h3>** 인덱스 2번째인 데이터 출력 **</h3>
${requestScope.list[2] } <!-- list라 배열처럼 취급, 데이터를 나타냄 -->

<h3>** jstlExam.jsp에서 넘어오는 데이터 **</h3>
${list2 }
<!-- JSTL은 pageScope → requestScope → sessionScope → applicationScope 순으로
호출하므로 requestScope 쓰지 않아도 됨 -->
<br><br>

<c:forEach var="personDTO" items="${list2}"> 
	이름 = ${personDTO.getName() } &emsp; 나이 = ${personDTO.getAge() } <br>
</c:forEach>
<!-- 자바코드에서 for(PersonDTO personDTO : list2)와 같음 -->

<h3>메소드명을 변수명처럼 사용</h3> <!-- set과 get 접두사와 () 빼기 -->
<c:forEach var="personDTO" items="${list2}"> 
	이름 = ${personDTO.name } &emsp; 나이 = ${personDTO.age } <br>
</c:forEach>

</body>
</html>

























