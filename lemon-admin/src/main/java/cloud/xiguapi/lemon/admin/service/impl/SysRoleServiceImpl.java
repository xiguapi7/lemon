package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.constants.SysConstants;
import cloud.xiguapi.lemon.admin.mapper.SysMenuMapper;
import cloud.xiguapi.lemon.admin.mapper.SysRoleMapper;
import cloud.xiguapi.lemon.admin.mapper.SysRoleMenuMapper;
import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.model.SysRole;
import cloud.xiguapi.lemon.admin.model.SysRoleMenu;
import cloud.xiguapi.lemon.admin.service.SysRoleService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 15:41 2020-07-27
 * description:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	private final SysRoleMapper mapper;

	private final SysRoleMenuMapper roleMenuMapper;

	private final SysMenuMapper menuMapper;

	@Autowired
	public SysRoleServiceImpl(SysRoleMapper mapper, SysRoleMenuMapper roleMenuMapper, SysMenuMapper menuMapper) {
		this.mapper = mapper;
		this.roleMenuMapper = roleMenuMapper;
		this.menuMapper = menuMapper;
	}

	@Override
	public int save(SysRole record) {
		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysRole record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysRole> records) {
		for (SysRole record : records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysRole findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParam("name");
		if (label != null) {
			return MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByName", label);
		}
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}

	@Override
	public List<SysRole> findAll() {
		return mapper.findAll();
	}


	@Override
	public List<SysMenu> findRoleMenus(Long roleId) {
		SysRole sysRole = mapper.selectByPrimaryKey(roleId);
		if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
			// 如果是超级管理员，返回全部
			return menuMapper.findAll();
		}
		return menuMapper.findRoleMenus(roleId);
	}

	@Transactional
	@Override
	public int saveRoleMenus(List<SysRoleMenu> records) {
		if (records == null || records.isEmpty()) {
			return 1;
		}
		Long roleId = records.get(0).getRoleId();
		roleMenuMapper.deleteByRoleId(roleId);
		for (SysRoleMenu record : records) {
			roleMenuMapper.insertSelective(record);
		}
		return 1;
	}

	@Override
	public List<SysRole> findByName(String name) {
		return mapper.findByName(name);
	}
}
