package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") //web.xml�� servlet �κа� ���� ��
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@Override
	public void init() throws ServletException {
		System.out.println("�������ڸ��� ���� ���� ȣ�� - init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Ŭ���̾�Ʈ ��û�� ���� ������ ���� - service()");		
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); //������ �����ִ� out
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
		System.out.println("���� ������ �� ȣ�� - destroy()");
	}
}

/*
class HelloTest extends Object{ } 
�ڹٴ� ��� Ŭ������ ������Ʈ�κ��� ��ӹ���, extends Object��������

class HelloTest extends HttpServlet{ } 
extends HttpServlet �ϸ� ���� ����ְڴٴ� ��. html �ʿ�

init()�� �������� ���� ���� ȣ��
������ �⺻�� doGet
----------------------------------------------------
init(), doGet(), destroy()�� ��� Call Back (�ݹ� �޼ҵ�) 
- � ������ �Ǹ� JVM�� ���� ȣ��Ǵ� �޼ҵ�

----------------------------------------------------
1. ����(Tomcat)�� helloServlet ������Ʈ�� �ø���
2. ������ web.xml(ȯ�漳�� ����) ã�Ƽ� �д´�. 
3. web.xml�� ���� ����ؾ� �Ѵ�.

----------------------------------------------------
1. �ܼ�â�� ���
System.out.println("<html>");

2. ���Ͽ� ���
PrintWriter out = new PrintWriter(new FileWrite("result.txt"));
out.println("<html>");

3.�ٸ� PC�� �̵�
PrintWriter out = new PrintWriter(new OutputStreamWrite(����.getOutputStream()));
out.println("<html>");

----------------------------------------------------
http://localhost:8080/helloServlet/com.hello.HelloServlet
http://localhost:8080/helloServlet/HelloServlet

*/












