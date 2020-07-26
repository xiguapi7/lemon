package cloud.xiguapi.lemon.admin.mapper;

import cloud.xiguapi.lemon.admin.model.SysLoginLog;
import cloud.xiguapi.lemon.admin.model.SysLoginLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author 大大大西西瓜皮🍉
 * date 00:50 2020-07-26
 * description:
 */
@Mapper
public interface SysLoginLogMapper {
	long countByExample(SysLoginLogExample example);

	int deleteByExample(SysLoginLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysLoginLog record);

	int insertSelective(SysLoginLog record);

	List<SysLoginLog> selectByExample(SysLoginLogExample example);

	SysLoginLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

	int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

	int updateByPrimaryKeySelective(SysLoginLog record);

	int updateByPrimaryKey(SysLoginLog record);
}