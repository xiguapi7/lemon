package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysRole;
import cloud.xiguapi.lemon.admin.model.SysRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysRoleMapper {
	long countByExample(SysRoleExample example);

	int deleteByExample(SysRoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	List<SysRole> selectByExample(SysRoleExample example);

	SysRole selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);

	List<SysRole> findPage();

	List<SysRole> findAll();

	List<SysRole> findPageByName(@Param(value = "name") String name);

	List<SysRole> findByName(@Param(value = "name") String name);
}