package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

/**
 * 菜单服务
 * <p>
 * author 大大大西西瓜皮🍉
 * date 00:16 2020-07-27
 * description:
 */
public interface SysMenuService extends CrudService<SysMenu> {


	/**
	 * 根据用户名查找菜单列表
	 *
	 * @param name 用户名
	 * @return 菜单列表
	 */
	List<SysMenu> findByUser(String name);

	/**
	 * 查询菜单树, 用户ID和用户名为空时就查询全部
	 *
	 * @param name 用户名
	 * @return 查询结果列表
	 */
	List<SysMenu> findTree(String name, int menuType);
}
