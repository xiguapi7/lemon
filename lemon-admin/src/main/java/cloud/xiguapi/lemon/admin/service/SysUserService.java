package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

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
}
