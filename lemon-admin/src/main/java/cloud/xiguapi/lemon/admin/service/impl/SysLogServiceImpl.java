package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysLogMapper;
import cloud.xiguapi.lemon.admin.model.SysLog;
import cloud.xiguapi.lemon.admin.service.SysLogService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:32 2020-07-27
 * description:
 */
@Service
public class SysLogServiceImpl implements SysLogService {

	private final SysLogMapper mapper;

	@Autowired
	public SysLogServiceImpl(SysLogMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int save(SysLog record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLog record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for (SysLog record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParam("userName");
		if (label != null) {
			return MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByUserName", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}
}
