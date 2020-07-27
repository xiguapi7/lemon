package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysDeptMapper;
import cloud.xiguapi.lemon.admin.model.SysDept;
import cloud.xiguapi.lemon.admin.service.SysDeptService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 机构服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:38 2020-07-27
 * description:
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

	private final SysDeptMapper mapper;

	@Autowired
	public SysDeptServiceImpl(SysDeptMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int save(SysDept record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDept record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDept> records) {
		for (SysDept record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDept findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}

	@Override
	public List<SysDept> findTree() {
		List<SysDept> sysDepts = new ArrayList<>();
		List<SysDept> depts = mapper.findAll();
		for (SysDept dept : depts) {
			if (dept.getParentId() == null || dept.getParentId() == 0) {
				dept.setLevel(0);
				sysDepts.add(dept);
			}
		}
		findChildren(sysDepts, depts);
		return sysDepts;
	}

	private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
		for (SysDept sysDept : sysDepts) {
			List<SysDept> children = new ArrayList<>();
			for (SysDept dept : depts) {
				if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
					dept.setParentName(dept.getName());
					dept.setLevel(sysDept.getLevel() + 1);
					children.add(dept);
				}
			}
			sysDept.setChildren(children);
			findChildren(children, depts);
		}
	}
}
