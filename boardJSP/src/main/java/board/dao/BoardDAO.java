package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds;
	
	private static BoardDAO instance;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	public static BoardDAO getInstance() {
		if(instance == null) { 
			synchronized (BoardDAO.class) {
				instance = new BoardDAO(); 
			}
		}
		return instance;
	}
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void boardWrite(BoardDTO boardDTO) {
		String sql = "insert into board(seq, id, name, email, subject, content, ref) "
				+ "values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId()); 
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());
			
			pstmt.executeUpdate();//실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
            	if (pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();		
		
		String sql = "select * from "
				+ "(select rownum rn, tt.* from "
				+ "(select * from board order by ref desc, step asc) tt "
				+ ")where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
	        
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(sdf.format(rs.getDate("logtime")));
					
				list.add(boardDTO);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if(rs != null) rs.close();
            	if(pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return list;
	}
	
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null; //생성하지 않고 null 값, 오류나면 바로 null 에러 뜨게
		String sql = "select * from board where seq=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(sdf.format(rs.getDate("logtime")));
			}
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
		
		return boardDTO;
	}
	
	public int getTotalA() {
		int totalA=0;
		String sql = "select count(*) from board";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next(); // 포지션 맞추고
			totalA = rs.getInt(1); // 1번 컬럼 값 가져와라
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
		
		return totalA;
	}
}




/*

synchronized (BoardDAO.class) 
동기화 작업: 순번을 정해줌, 누가 쓰고 있으면 잠깐 못 들어가는 순번 작업
--------------------------------------------

Connection Pool (jdbc/oracle) 
	↑↓ 
DataSource
	↑↓ 
 클라이언트

-------------------------------------------- 
WEB-INF 웹에 관한 정보 META-INF 웹이 아닌
정보

Connection Pool은 DB와 관련이 있으므로 META-INF에 context.xml 만듭니다. 
context.xml에서 name을 jdbc/oracle로 하였으므로, 
<Resource name="jdbc/oracle" ~~/>

Naming Service에 따라 lookup메소드를 이용하여 값을 가져와서 데이터소스에 저장합니다. 
Object 타입을 DataSource로 형변환합니다. 
Context ctx = new InitialContext(); ds = (DataSource)
ctx.lookup("java:comp/env/jdbc/oracle"); // Tomcat의 경우

-------------------------------------------- 
insert into board values() 
테이블의 모든 컬럼을 빠짐없이 순서대로 기입해야 합니다.

insert into board(컬럼명, 컬럼명..) values() 
테이블의 원하는 컬럼을 순서 상관없이 기입할 수 있습니다.
--------------------------------------------

select * from board order by ref desc, step asc;

select rownum rn, tt.* from (select * from board order by ref desc, step asc)
tt;

select * from (select rownum rn, tt.* from (select * from board order by ref
desc, step asc) tt ) where rn>=6 and rn<=10;


 */










