package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
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
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//src
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		sqlSession.close();
		return list;
	}

	public BoardDTO getBoardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoardView", seq);
		sqlSession.close();
		return boardDTO;
	}

	public void boardModify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("boardSQL.boardModify", map);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA"); //가져가는 데이터 없음
		sqlSession.close();		
		return totalA;
	}

	public void boardReply(Map<String, String> map) {
		//원글
		BoardDTO pDTO = getBoardView(Integer.parseInt(map.get("pseq"))); //원글번호

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//step(글순서) update
		//update board set step=step+1 where ref=#{원글ref} and step > #{원글step}
		sqlSession.update("boardSQL.boardReply1", pDTO);
		
		//insert
		map.put("ref", pDTO.getRef()+""); //답글의 ref = 원글의 ref
		map.put("lev", pDTO.getLev()+ 1 +""); //답글의 lev = 원글의 lev + 1
		map.put("step", pDTO.getStep()+ 1 +""); //답글의 step = 원글의 step + 1
		
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//reply(답글수) update
		//update board set reply=reply+1 where seq=#{pseq}
		sqlSession.update("boardSQL.boardReply3", Integer.parseInt(map.get("pseq")));
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("boardSQL.boardDelete", seq);
		sqlSession.commit();
		sqlSession.close();
	}
	
}















