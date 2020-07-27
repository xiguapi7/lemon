package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysConfigMapper;
import cloud.xiguapi.lemon.admin.model.SysConfig;
import cloud.xiguapi.lemon.admin.service.SysConfigService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 配置服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:41 2020-07-27
 * description:
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

	private final SysConfigMapper mapper;

	@Autowired
	public SysConfigServiceImpl(SysConfigMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int save(SysConfig record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysConfig record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysConfig> records) {
		for (SysConfig record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysConfig findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParam("label");
		if (label != null) {
			return MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByLabel", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}

	@Override
	public List<SysConfig> findByLable(String lable) {
		return mapper.findByLable(lable);
	}
}
