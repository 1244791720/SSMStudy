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
	 * @param resource mybatis配置文件路径
	 * @return SQLSession对象
	 */
	public static SqlSession OpenSqlSession(String resource) {
		SqlSessionFactory ssf = getSqlSessionFactoury(resource);
		SqlSession sqlSession = null;
		try {
			sqlSession = ssf.openSession();
			sqlSession.commit(); //提交事务
		} catch(Exception e) {
			sqlSession.rollback(); //事务回滚
		} finally {
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
		}
		return sqlSession;
	}

}
