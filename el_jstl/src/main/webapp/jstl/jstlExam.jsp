<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jstl.PersonDTO"%>

<%
//자바 파일의 역할 ---> 여기서 실행하세요

List<String> list = new ArrayList<String>();
list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("오랑우탄");
list.add("코끼리");
list.add("코알라");
list.add("여우");

PersonDTO aa = new PersonDTO("크리스", 25);
PersonDTO bb = new PersonDTO("데이빗", 28);
PersonDTO cc = new PersonDTO("프레드", 30);

List<PersonDTO> list2 = new ArrayList<PersonDTO>();
list2.add(aa);
list2.add(bb);
list2.add(cc);

//데이터
request.setAttribute("list", list); //("변수명", 값)
request.setAttribute("list2", list2);

//페이지 이동
//response.sendRedirect("jstlTest.jsp");

//forward
RequestDispatcher dispatcher = request.getRequestDispatcher("jstlTest.jsp");
dispatcher.forward(request, response);
%>

<%-- <jsp:forward page="jstlTest.jsp" /> --%>




<!-- 
자바 따로 웹 따로 하려면, 데이터를 공유해야 하므로 포워드 개념이 사용됨
import할 곳 클릭하고 Ctrl + space bar 하면 import 할 수 있음
get 방식은 주소를 타고 데이터가 갑니다. 
주소를 통해서 가는 데이터는 문자열밖에 안 갑니다. 
객체는 주소를 통해 갈 수 없습니다.
 -->
 