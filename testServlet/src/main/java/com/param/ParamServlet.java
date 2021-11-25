package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ParamServlet") //어노테이션 형식
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doget()");
		
		//데이터
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕 서블릿!!");
		out.println("<br><br>");
		
		out.println(name + "님의 나이는 " + age + "살 이므로 ");
		if(age>=19) 
			out.println("성인 입니다.");
		else 
			out.println("청소년 입니다.");
		
		out.println("</body>");
		out.println("</html>");
	}
}

/*
url 웹에서 처리하는 주소

XML 형식 - web.xml에 지정
어노테이션 형식 - @WebServlet("url")

Tomcat을 켜면 가장 먼저 Project의 web.xml을 읽는다
*.java를 컴파일 하면 무조건 Tomcat은 껐다가 켜진다

URL
                 webapps
http://localhost:8080/Context명 (Tomcat)
http://localhost:8080/Project명 (Eclipse)

Context명과 Project명은 같은 개념

http://localhost:8080/testServlet/com.param.ParamServlet
http://localhost:8080/testServlet/ParamServlet

이클립스가 제공하는 가상폴더는 url에 쓸 필요 없음
확장자 .class 생략
-----------------------------------------------------
1. 콘솔에 출력
System.out.println("<html>");

2. 파일에 출력
PrintWriter out = new PrintWriter(new FileWrite("result.txt"));
out.println("<html>");

3. 네트워크로 다른 PC로 넘어갈 때
PrintWriter out = new PrintWriter(new OutputStreamWrite(Socket.getOutputStream()));
out.println("<html>");

4. Web
PrintWriter out = response.getWriter();
out.println("<html>");

--------------------------------------------
브라우저는 println이 안 먹히고 <br>이 필요
println은 소스보기에서 소스를 다음줄로 줄바꿈 함
 */