package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysUserRole;
import cloud.xiguapi.lemon.admin.model.SysUserRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysUserRoleMapper {
	long countByExample(SysUserRoleExample example);

	int deleteByExample(SysUserRoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysUserRole record);

	int insertSelective(SysUserRole record);

	List<SysUserRole> selectByExample(SysUserRoleExample example, @Param("listItem") String listItem);

	SysUserRole selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example, @Param("listItem") String listItem);

	int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

	int updateByPrimaryKeySelective(SysUserRole record);

	int updateByPrimaryKey(SysUserRole record);

	List<SysUserRole> findUserRoles(Long userId);
}