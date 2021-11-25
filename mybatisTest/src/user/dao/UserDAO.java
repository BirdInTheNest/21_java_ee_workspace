package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private static UserDAO instance = null;
	private SqlSessionFactory sqlSessionFactory; //Config 환경설정 파일을 읽음

	public static UserDAO getInstance() {
		if(instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO(); //생성
			}
		}

		return instance;
	}
	
	public UserDAO() {
		/*
		* IO Stream
		1. byte 단위(영문자)
		InputStream
		OutputStream
		
		2. 문자 단위(1개, 2byte, unicode)
		Reader
		Writer
		
		mybatis-config.xml에 설정한 환경설정을 읽습니다.
		
		web.xml만 자동으로 읽고, 나머지는 읽으라고 알려줘야 합니다.
		UserDAO.java 에서 
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		읽으라고 알려주고, 
		
		mybatis-config.xml 에서는
		<properties resource="db.properties"></properties>
		읽으라고 알려줍니다. 
		*/
		try {
			//InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit(); //insert, update, delete
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//메소드가 자동으로 리스트에 담는다 list.add(UserDTO); 이런거 안 해도 됨
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close(); 
		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id); //리턴값을 UserDTO로 자동으로 담는다
		sqlSession.close();
		return userDTO;
	}

	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.update", map);
		sqlSession.commit(); //insert, update, delete
		sqlSession.close();
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit(); //insert, update, delete
		sqlSession.close();
	}

	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		sqlSession.close();
		return list;
	}

}
