package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysLog;
import cloud.xiguapi.lemon.admin.model.SysLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysLogMapper {
	long countByExample(SysLogExample example);

	int deleteByExample(SysLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysLog record);

	int insertSelective(SysLog record);

	List<SysLog> selectByExample(SysLogExample example);

	SysLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByPrimaryKeySelective(SysLog record);

	int updateByPrimaryKey(SysLog record);
}