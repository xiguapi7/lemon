package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.constants.SysConstants;
import cloud.xiguapi.lemon.admin.mapper.SysMenuMapper;
import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.service.SysMenuService;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 菜单服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 00:16 2020-07-27
 * description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	private final SysMenuMapper mapper;

	@Autowired
	public SysMenuServiceImpl(SysMenuMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<SysMenu> findByUser(String name) {

		if (StringUtils.isEmpty(name) || SysConstants.ADMIN.equalsIgnoreCase(name)) {
			return mapper.findAll();
		}
		return mapper.findPageByName(name);
	}

	@Override
	public List<SysMenu> findTree(String name, int menuType) {

		List<SysMenu> list = new ArrayList<>();
		List<SysMenu> menus = findByUser(name);

		menus.forEach(menu -> {
			if (menu.getParentId() == null || menu.getParentId() == 0) {
				menu.setLevel(0);
				if (!exists(list, menu)) {
					list.add(menu);
				}
			}
		});

		list.sort(Comparator.comparing(SysMenu::getOrderNum));
		findChildren(list, menus, menuType);

		return list;
	}

	private void findChildren(List<SysMenu> list, List<SysMenu> menus, int menuType) {
		list.forEach(sysMenu -> {
			List<SysMenu> children = new ArrayList<>();
			menus.forEach(menu -> {
				if (!(menuType == 1 && menu.getType() == 2)) {
					if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
						menu.setParentName(sysMenu.getParentName());
						menu.setLevel(sysMenu.getLevel() + 1);
						if (!exists(children, menu)) {
							children.add(menu);
						}
					}
				}
			});

			sysMenu.setChildren(children);
			children.sort(Comparator.comparing(SysMenu::getOrderNum));
			findChildren(children, menus, menuType);
		});
	}

	private boolean exists(List<SysMenu> menus, SysMenu menu) {
		AtomicBoolean exist = new AtomicBoolean(false);
		menus.forEach(m -> {
			if (m.getId().equals(menu.getId())) {
				exist.set(true);
			}
		});
		return exist.get();
	}

	@Override
	public int save(SysMenu record) {

		if (record.getId() == null || record.getId() == 0) {
			return mapper.insertSelective(record);
		}

		if (record.getParentId() == null) {
			record.setParentId(0L);
		}

		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysMenu record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysMenu> list) {
		list.forEach(this::delete);
		return 1;
	}

	@Override
	public SysMenu findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MyBatisPageHelper.findPage(pageRequest, mapper);
	}
}
