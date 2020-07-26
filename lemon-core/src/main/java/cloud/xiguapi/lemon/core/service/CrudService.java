package cloud.xiguapi.lemon.core.service;

import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;

import java.util.List;

/**
 * 通用CRUD接口
 *
 * @author 大大大西西瓜皮🍉
 * @date 16:05 2020-07-26
 * description:
 */
public interface CrudService<T> {

	/**
	 * 保存
	 *
	 * @param record 存储记录
	 * @return 返回SQL操作影响行数
	 */
	int save(T record);

	/**
	 * 删除
	 *
	 * @param record 待删除记录对象
	 * @return 返回SQL操作影响行数
	 */
	int delete(T record);

	/**
	 * 批量删除
	 *
	 * @param list 待删除对象的列表
	 * @return 返回SQL操作影响的行数
	 */
	int delete(List<T> list);

	/**
	 * 根据ID查找对象
	 *
	 * @param id ID
	 * @return 查找结果
	 */
	T findById(Long id);

	/**
	 * 分页查找
	 * 统一封装分页请求和结果，避免直接引入具体框架的分页对象在更换ORM时候引起变动的情况。
	 *
	 * @param pageRequest 自定义，统一分页查找请求对象
	 * @return 自定义，统一分页查询结果
	 */
	PageResult findPage(PageRequest pageRequest);
}
