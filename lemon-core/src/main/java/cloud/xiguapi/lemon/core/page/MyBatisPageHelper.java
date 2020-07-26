package cloud.xiguapi.lemon.core.page;

import cloud.xiguapi.lemon.common.tool.ReflectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * MyBatis分页查询工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 16:18 2020-07-26
 * description:
 */
public class MyBatisPageHelper {

	public static final String FIND_PAGE = "findPage";

	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求对象
	 * @param mapper      Dao对象, MyBatis的Mapper
	 * @return 自定义封装的分页结果
	 */
	public static PageResult findPage(PageRequest pageRequest, Object mapper) {
		return findPage(pageRequest, mapper, FIND_PAGE);
	}

	/**
	 * 使用分页插件插件进行分页查询
	 *
	 * @param pageRequest     分页请求
	 * @param mapper          Dao对象, MyBatis的Mapper
	 * @param queryMethodName 要分页的查询方法名
	 * @param args            方法参数
	 * @return 自定义封装的分页结果
	 */
	public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {

		// 设置分页参数
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);

		// 反射调用方法
		Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);

		return getPageResult(pageRequest, new PageInfo((List) result));
	}

	/**
	 * 封装查询结果对象
	 *
	 * @param pageRequest 查询请求
	 * @param pageInfo    MyBatis分页结果对象
	 * @return 自定义查询结果对象
	 */
	private static PageResult getPageResult(PageRequest pageRequest, PageInfo pageInfo) {
		PageResult result = new PageResult();
		result.setPageNum(pageRequest.getPageNum());
		result.setPageSize(pageRequest.getPageSize());
		result.setTotalPages(pageInfo.getPages());
		result.setTotalSize(pageInfo.getTotal());
		result.setContent(pageInfo.getList());
		return result;
	}
}
