package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysDept;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

/**
 * 机构服务
 * <p>
 * author 大大大西西瓜皮🍉
 * date 17:37 2020-07-27
 * description:
 */
public interface SysDeptService extends CrudService<SysDept> {

	/**
	 * 查询机构树
	 */
	List<SysDept> findTree();
}
