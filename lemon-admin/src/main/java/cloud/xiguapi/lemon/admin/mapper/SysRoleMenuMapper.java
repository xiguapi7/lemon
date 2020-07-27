package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysRoleMenu;
import cloud.xiguapi.lemon.admin.model.SysRoleMenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysRoleMenuMapper {
	long countByExample(SysRoleMenuExample example);

	int deleteByExample(SysRoleMenuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysRoleMenu record);

	int insertSelective(SysRoleMenu record);

	List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

	SysRoleMenu selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

	int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

	int updateByPrimaryKeySelective(SysRoleMenu record);

	int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

	List<SysRoleMenu> findAll();

	int deleteByRoleId(@Param(value = "roleId") Long roleId);
}