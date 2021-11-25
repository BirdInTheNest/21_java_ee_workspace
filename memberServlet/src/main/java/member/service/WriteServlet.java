package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//데이터 (name 속성으로 데이터를 가져온다, id속성은 js, css 적용할 때 사용)
		request.setCharacterEncoding("UTF-8"); //요청에 대한 한글 처리 - post 방식일 때
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤 - 1번 생성해서 계속 사용한다.
		memberDAO.write(memberDTO);//호출
		         
		//응답
		response.setContentType("text/html;charset=UTF-8"); //응답에 대한 한글 처리
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("회원가입을 축하합니다<br><br>");
		out.println("<input type=button value=로그인 "
				+ "onclick=location.href='/memberServlet/member/loginForm.html'>");
		out.println("</body>");
		out.println("</html>");
	}

}

/*
클라이언트가 요청하면 반드시 서버는 그것을 처리(서버가 데이터를 받고, DB도 다녀오고)하고 응답을 해줘야 합니다.
오라클 데이터 베이스명, 포트번호, 계정명을 알아서 그 속에 있는 테이블에 정보를 넣거나 꺼내옵니다. 
-------------------------------------

어떤 클래스가 있는지 쭉 적고, 이 클래스가 이 클래스를 부르는구나,
메소드가 누가 누구를 요청하는지 분석하고 그림 그리는 것이 필요합니다. 

------------------------
submit ~ action(페이지 이동 + 데이터)
submit을 하게 되면 입력데이터를 action 타고 서버에 가져갑니다.  

 */









