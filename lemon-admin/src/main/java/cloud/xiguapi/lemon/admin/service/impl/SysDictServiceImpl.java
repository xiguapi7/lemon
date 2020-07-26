package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysDictMapper;
import cloud.xiguapi.lemon.admin.model.SysDict;
import cloud.xiguapi.lemon.admin.service.SysDictService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 18:35 2020-07-26
 * description:
 */
@Service
public class SysDictServiceImpl implements SysDictService {

	private final SysDictMapper mapper;

	@Autowired
	public SysDictServiceImpl(SysDictMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<SysDict> findByLabel(String label) {
		return mapper.findByLabel(label);
	}

	@Override
	public int save(SysDict record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDict record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> list) {
		list.forEach(this::delete);
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
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
}
