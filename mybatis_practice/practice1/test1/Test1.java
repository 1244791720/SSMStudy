package test1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import mapper.RoleMapper;
import po.Role;
import utils.DatabaseConnectionUtil;

public class Test1 {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void test1() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test1.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		Role r = rm.getRole(1L);
		System.out.println(r);
		sqlSession.close();
	}
	
	@Test
	public void test2() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		Role r = rm.getRole(1L);
		System.out.println(r);
		sqlSession.close();
	}
	
	
	
}
