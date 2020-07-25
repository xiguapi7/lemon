package cloud.xiguapi.lemon.mapper;

import cloud.xiguapi.lemon.model.SysRoleDept;
import cloud.xiguapi.lemon.model.SysRoleDeptExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysRoleDeptMapper {
	long countByExample(SysRoleDeptExample example);

	int deleteByExample(SysRoleDeptExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysRoleDept record);

	int insertSelective(SysRoleDept record);

	List<SysRoleDept> selectByExample(SysRoleDeptExample example);

	SysRoleDept selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

	int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

	int updateByPrimaryKeySelective(SysRoleDept record);

	int updateByPrimaryKey(SysRoleDept record);
}