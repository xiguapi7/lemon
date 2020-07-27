package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysLoginLogMapper;
import cloud.xiguapi.lemon.admin.model.SysLoginLog;
import cloud.xiguapi.lemon.admin.service.SysLoginLogService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录日志服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:35 2020-07-27
 * description:
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

	private final SysLoginLogMapper mapper;

	@Autowired
	public SysLoginLogServiceImpl(SysLoginLogMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int save(SysLoginLog record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLoginLog record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLoginLog> records) {
		for (SysLoginLog record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLoginLog findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object userName = pageRequest.getParam("userName");
		if (userName != null) {
			return MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByUserName", userName);
		}
		Object status = pageRequest.getParam("status");
		if (status != null) {
			return MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByStatus", status);
		}
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}
}
