package test1;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	
	@Test
	public void testInsertRole() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		for (long i = 20L; i < 40; i++) {
			Role role = new Role(i,"ŵ��", "��ͷ��");
			 int it = rm.insertRole(role);
			System.out.println(it);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindByRowBounds() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		String roleName = "ŵ��";
		RowBounds rowBounds = new RowBounds(0,15);
		List<Role> list = rm.findByRowBounds(roleName, rowBounds);
		System.out.println(list);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindByRowBoundsIf() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		String roleName = "��";
		List<Role> list = rm.findByNameIf(roleName);
		System.out.println(list);
	}
	
	@Test
	public void testFindByNameAndNote() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		Role role1 = new Role("��","��ͷ��"); // note����
		Role role2 = new Role("��ɪ",""); //name����
		Role role3 = new Role("",""); //otherwise
		List<Role> list = rm.findByNameAndNote(role3);
		System.out.println(list);
	}
	
	@Test
	public void testfindWhere() {
		SqlSession sqlSession = DatabaseConnectionUtil.OpenSqlSession("test2.xml");
		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
		Role role1 = new Role("��","��ͷ��"); // note����
		List<Role> list = rm.findByNameAndNote(role1);
		System.out.println(list);
	}
}
