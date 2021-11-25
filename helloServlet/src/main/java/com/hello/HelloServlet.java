package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") //web.xml의 servlet 부분과 같은 뜻
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@Override
	public void init() throws ServletException {
		System.out.println("실행하자마자 제일 먼저 호출 - init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("클라이언트 요청이 있을 때마다 실행 - service()");		
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); //웹으로 보내주는 out
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!");
		out.println("</body>");
		out.println("</html>");		
	}
	
	@Override
	public void destroy() {
		System.out.println("서블릿 종료할 때 호출 - destroy()");
	}
}

/*
class HelloTest extends Object{ } 
자바는 모든 클래스가 오브젝트로부터 상속받음, extends Object생략가능

class HelloTest extends HttpServlet{ } 
extends HttpServlet 하면 웹에 띄워주겠다는 뜻. html 필요

init()은 서블릿에서 가장 먼저 호출
무조건 기본은 doGet
----------------------------------------------------
init(), doGet(), destroy()는 모두 Call Back (콜백 메소드) 
- 어떤 시점이 되면 JVM에 의해 호출되는 메소드

----------------------------------------------------
1. 서버(Tomcat)에 helloServlet 프로젝트를 올리면
2. 무조건 web.xml(환경설정 파일) 찾아서 읽는다. 
3. web.xml에 서블릿 등록해야 한다.

----------------------------------------------------
1. 콘솔창에 출력
System.out.println("<html>");

2. 파일에 출력
PrintWriter out = new PrintWriter(new FileWrite("result.txt"));
out.println("<html>");

3.다른 PC로 이동
PrintWriter out = new PrintWriter(new OutputStreamWrite(소켓.getOutputStream()));
out.println("<html>");

----------------------------------------------------
http://localhost:8080/helloServlet/com.hello.HelloServlet
http://localhost:8080/helloServlet/HelloServlet

*/












