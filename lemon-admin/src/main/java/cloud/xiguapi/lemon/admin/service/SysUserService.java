package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.model.SysUserRole;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 用户接口
 * <p>
 * author 大大大西西瓜皮🍉
 * date 00:58 2020-07-26
 * description:
 */
public interface SysUserService extends CrudService<SysUser> {

	/**
	 * 查询所有用户
	 *
	 * @return 查询结果
	 */
	List<SysUser> findAll();

	/**
	 * 根据用户名查找用户
	 *
	 * @param name 用户名
	 * @return 用户对象, id不为空或不为0则代表存在
	 */
	SysUser findByName(String name);

	/**
	 * 查找用户的菜单权限标识集合
	 *
	 * @param name 用户名
	 * @return 查询结果
	 */
	Set<String> findPermissions(String name);

	/**
	 * 查找用户权限集合
	 *
	 * @param userId 用户ID
	 * @return 查找结果
	 */
	List<SysUserRole> findUserRoles(Long userId);

	/**
	 * 生成用户信息报表
	 *
	 * @param request 分页请求对象
	 * @return 返回结果
	 */
	File createUserExcelFile(PageRequest request);
}
