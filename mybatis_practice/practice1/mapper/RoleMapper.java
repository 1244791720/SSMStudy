package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import po.Role;

public interface RoleMapper {
	public Role getRole(Long id);
	
	public int insertRole(Role role);
	
	//分页参数RowBounds
	public List<Role> findByRowBounds(@Param("roleName") String roleName, RowBounds rowBounds);
	
	//动态 Sql IF 元素
	public List<Role> findByNameIf(@Param("roleName") String roleName);
	
	//动态sql choose when otherwise 元素
	public List<Role> findByNameAndNote(Role role);
	
	//动态sql where
	public List<Role> findWhere(Role role); 
	
	//动态sql trim
	public List<Role> findTrim(Role role); 
	
	
}
