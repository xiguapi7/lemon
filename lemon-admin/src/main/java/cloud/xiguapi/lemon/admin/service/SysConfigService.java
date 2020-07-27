package cloud.xiguapi.lemon.admin.service;

import cloud.xiguapi.lemon.admin.model.SysConfig;
import cloud.xiguapi.lemon.core.service.CrudService;

import java.util.List;

/**
 * 配置服务接口
 * <p>
 * author 大大大西西瓜皮🍉
 * date 17:40 2020-07-27
 * description:
 */
public interface SysConfigService extends CrudService<SysConfig> {

	/**
	 * 根据名称查询
	 */
	List<SysConfig> findByLable(String lable);
}
