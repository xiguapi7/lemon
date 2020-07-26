package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.service.SysMenuService;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大大大西西瓜皮🍉
 * @date 00:16 2020-07-27
 * description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Override
	public List<SysMenu> findByUser(String name) {
		return null;
	}

	@Override
	public int save(SysMenuService record) {
		return 0;
	}

	@Override
	public int delete(SysMenuService record) {
		return 0;
	}

	@Override
	public int delete(List<SysMenuService> list) {
		return 0;
	}

	@Override
	public SysMenuService findById(Long id) {
		return null;
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return null;
	}
}
