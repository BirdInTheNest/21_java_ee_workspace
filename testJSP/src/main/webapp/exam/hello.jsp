<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//전역, 1번, init()
String name = "Rose";
int age = 24;
%>

<%
//지역, 매번, service()
age++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Hello JSP!!<br> --> 

<%-- 안녕하세요 JSP!!<br> --%> 

나의 이름은 <%=name %> 입니다.<br>

<!-- 내 나이는 <%=age %>살 입니다.<br> -->

<%-- <% out.println("내 나이는 " + age + "살 입니다"); %> --%>
</body>
</html>
 
<!-- 
서블릿               JSP
웹                  웹
html in JAVA       java in HTML

---------------------------------
자바에서

Class Test {
	Private String name; //필드, 클래스 소속, 전역변수, 메모리에 1번 생성
	
	public void sub(){
		String name; //함수 소속, 지역변수

	}
}
---------------------------------


hello.jsp
hello_jsp.java (서블릿)
hello_jsp.class

jsp에 자바코드가 있으면 컴파일(기계어로 번역) 해야 컴퓨터가 분석할 수 있습니다.
모든 jsp 파일은 내부적으로 서블릿 파일 만들고, 컴파일해서 클래스 파일도 만듭니다. 
jsp는 서블릿 파일이 자동으로 만들어지면서 내장 객체를 만들기 때문에, 따로 만들 필요가 없습니다.  
jsp는 무거워서 잘 안 쓰입니다. 

서블릿은 수정되면 자동으로 톰캣(서버)이 껐다가 켜지면서 init()를 먼저 수행합니다.

---------------------------------
자바에서 주석
//1줄

/*
2줄
*/
 -->

 
<!-- HTML 주석은 웹에 왔기 때문에, 수행은 되나 화면에 안 보임, F12하면 보인다 -->

<%-- JSP 주석은 웹에 오지 않고 jsp에서 소멸 --%>

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 