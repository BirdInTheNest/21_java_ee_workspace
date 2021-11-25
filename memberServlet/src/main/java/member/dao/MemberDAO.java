package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn=null;
	private PreparedStatement pstmt;
	private ResultSet rs; //ResultSet 인터페이스는 select의 결과값 받음
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private static MemberDAO instance = null; //초기값 null
	
	public static MemberDAO getInstance() { //인스턴스 - 메모리 생성
		if(instance == null) { //맨 처음으로 생성하는 것인지
			synchronized (MemberDAO.class) { //동기화 처리
				instance = new MemberDAO(); //생성 - 딱 한번만 생성됨
			}
		}
		
		return instance;
	}
	
	public MemberDAO() { //Driver Loading
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() { //Connection
		try {
			conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void write(MemberDTO memberDTO) {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			pstmt.executeUpdate(); //실행

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public String login(String id, String pwd) {
		String name = null; //초기값
		String sql = "select * from member where id=? and pwd=?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery(); //실행
			
			if(rs.next()) name = rs.getString("name");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return name;
	}

	public boolean isCheckId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) exist = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return exist;
	}

}

/*
클래스
Object 상속
new 로 생성

서블릿
웹 - 요청/응답 
HttpServlet
new로 생성하지 않음, 서버에 의해 생성
 

Ctrl Shitf O : 클래스에 불필요한 import구문을 제거해주고, 필요한 구문은 자동으로 추가해주는 기능
 */

















