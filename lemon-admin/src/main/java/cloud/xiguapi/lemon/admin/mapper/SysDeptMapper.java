package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysDept;
import cloud.xiguapi.lemon.admin.model.SysDeptExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysDeptMapper {
	long countByExample(SysDeptExample example);

	int deleteByExample(SysDeptExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysDept record);

	int insertSelective(SysDept record);

	List<SysDept> selectByExample(SysDeptExample example);

	SysDept selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

	int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

	int updateByPrimaryKeySelective(SysDept record);

	int updateByPrimaryKey(SysDept record);

	List<SysDept> findPage();

	List<SysDept> findAll();
}