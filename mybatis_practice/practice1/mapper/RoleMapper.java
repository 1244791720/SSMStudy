package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import po.Role;

public interface RoleMapper {
	public Role getRole(Long id);
	
	public int insertRole(Role role);
	
	//∑÷“≥≤Œ ˝RowBounds
	public List<Role> findByRowBounds(@Param("roleName") String roleName, RowBounds rowBounds);
}
