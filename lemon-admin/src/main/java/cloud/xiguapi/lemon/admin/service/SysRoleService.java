package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.model.SysRole;
import cloud.xiguapi.lemon.admin.model.SysRoleMenu;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

/**
 * 角色服务接口
 *
 * @author 大大大西西瓜皮🍉
 * @date 15:40 2020-07-27
 * description:
 */
public interface SysRoleService extends CrudService<SysRole> {

	/**
	 * 查询全部
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 */
	List<SysMenu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 */
	int saveRoleMenus(List<SysRoleMenu> records);

	/**
	 * 根据名称查询
	 */
	List<SysRole> findByName(String name);
}
