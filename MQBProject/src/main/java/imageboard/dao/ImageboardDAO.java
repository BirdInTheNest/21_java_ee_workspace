package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static ImageboardDAO getInstance() {
		if(instance == null) { 
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO(); 
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//src
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite",imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ImageboardDTO> getImageboardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.getImageboardList", map);
		sqlSession.close();
		return list;
	}

	public int getImageboardTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("imageboardSQL.getImageboardTotalA");
		sqlSession.close();
		return totalA;
	}

	public void imageboardDelete(String[] check) { //파라미터값은 배열 String[] check
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("check", check); //Map에 배열 String[] check 넣기
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("imageboardSQL.imageboardDelete", map);
		sqlSession.commit();
		sqlSession.close();

		/* for문으로 하나씩 보내는 방법
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		for(int i=0; i<check.length; i++) {
			sqlSession.delete("imageboardSQL.imageboardDelete", check[i]);
		}//for
		
		sqlSession.commit();
		sqlSession.close(); */	
	}

}














