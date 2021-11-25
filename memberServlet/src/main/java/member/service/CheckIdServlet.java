package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

@WebServlet("/CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//데이터
		String id = request.getParameter("id");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean exist = memberDAO.isCheckId(id); //boolean값은 is, 값을 가져올 때는 get
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		if(exist)
			out.println("아이디 \" + id + \"은(는) 사용 불가능");
		else
			out.println("아이디 \" + id + \"은(는) 가능");
		
		out.println("</body>");
		out.println("</html>");
	}

}

/*
select * from member where id='hong';

rs.next() -> T -> 사용 불가능
rs.next() -> F -> 사용 가능
 */











