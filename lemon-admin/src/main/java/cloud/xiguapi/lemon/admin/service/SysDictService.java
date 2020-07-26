package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysDict;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

/**
 * 字典服务接口
 * <p>
 * author 大大大西西瓜皮🍉
 * date 18:32 2020-07-26
 * description:
 */
public interface SysDictService extends CrudService<SysDict> {

	/**
	 * 根据标签查询
	 *
	 * @param label 标签
	 * @return 查询结果
	 */
	List<SysDict> findByLabel(String label);
}
