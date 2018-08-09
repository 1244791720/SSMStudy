package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseConnectionUtil {
	private static SqlSessionFactory getSqlSessionFactoury(String resource) {
		SqlSessionFactory sqlSessionFactory = null;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
			return sqlSessionFactory;
	}
	
	/**
	 * 
	 * @param resource mybatis�����ļ�·��
	 * @return SQLSession����
	 */
	public static SqlSession OpenSqlSession(String resource) {
		SqlSessionFactory ssf = getSqlSessionFactoury(resource);
		SqlSession sqlSession = null;
		try {
			sqlSession = ssf.openSession();
			sqlSession.commit(); //�ύ����
		} catch(Exception e) {
			sqlSession.rollback(); //����ع�
		} finally {
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
		}
		return sqlSession;
	}

}
