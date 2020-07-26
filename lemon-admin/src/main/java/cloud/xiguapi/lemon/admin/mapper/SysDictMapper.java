package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysDict;
import cloud.xiguapi.lemon.admin.model.SysDictExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysDictMapper {
	long countByExample(SysDictExample example);

	int deleteByExample(SysDictExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysDict record);

	int insertSelective(SysDict record);

	List<SysDict> selectByExample(SysDictExample example, @Param("listItem") String listItem);

	SysDict selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example, @Param("listItem") String listItem);

	int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

	int updateByPrimaryKeySelective(SysDict record);

	int updateByPrimaryKey(SysDict record);

	List<SysDict> findPage();

	List<SysDict> findByLabel(@Param("label") String label);

	List<SysDict> findPageByLabel(@Param("label") String label);
}