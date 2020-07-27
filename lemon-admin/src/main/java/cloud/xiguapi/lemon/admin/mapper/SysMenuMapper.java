package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.model.SysMenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysMenuMapper {
	long countByExample(SysMenuExample example);

	int deleteByExample(SysMenuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysMenu record);

	int insertSelective(SysMenu record);

	List<SysMenu> selectByExample(SysMenuExample example);

	SysMenu selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	int updateByPrimaryKeySelective(SysMenu record);

	int updateByPrimaryKey(SysMenu record);

	List<SysMenu> findPage();

	List<SysMenu> findPageByName(@Param(value = "name") String name);

	List<SysMenu> findAll();

	List<SysMenu> findByUserName(@Param(value = "userName") String userName);

	List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
}