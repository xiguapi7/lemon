package cloud.xiguapi.lemon.core.page;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一封装分页请求对象
 *
 * @author 大大大西西瓜皮🍉
 * @date 16:10 2020-07-26
 * description:
 */
public class PageRequest {

	/**
	 * 当前页码
	 */
	private int pageNum = 1;

	/**
	 * 每页数量
	 */
	private int pageSize = 10;

	/**
	 * 查询参数
	 */
	private Map<String, Object> params = new HashMap<>();

	public PageRequest() {

	}

	public PageRequest(int pageNum, int pageSize, Map<String, Object> params) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.params = params;
	}

	public PageRequest(int pageNum, int pageSize) {
		this(pageNum, pageSize, Collections.emptyMap());
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Object getParam(String key) {
		return getParams().get(key);
	}
}
