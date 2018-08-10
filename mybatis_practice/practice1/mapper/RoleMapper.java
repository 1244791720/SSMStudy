package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import po.Role;

public interface RoleMapper {
	public Role getRole(Long id);
	
	public int insertRole(Role role);
	
	//��ҳ����RowBounds
	public List<Role> findByRowBounds(@Param("roleName") String roleName, RowBounds rowBounds);
	
	//��̬ Sql IF Ԫ��
	public List<Role> findByNameIf(@Param("roleName") String roleName);
	
	//��̬sql choose when otherwise Ԫ��
	public List<Role> findByNameAndNote(Role role);
	
	//��̬sql where
	public List<Role> findWhere(Role role); 
	
	//��̬sql trim
	public List<Role> findTrim(Role role); 
	
	
}
