package cloud.xiguapi.lemon.core.page;

import java.util.Collections;
import java.util.List;

/**
 * 统一封装分页结果
 *
 * @author 大大大西西瓜皮🍉
 * @date 16:09 2020-07-26
 * description:
 */
public class PageResult {

	/**
	 * 当前页码
	 */
	private int pageNum;

	/**
	 * 每页数量
	 */
	private int pageSize;

	/**
	 * 记录总数
	 */
	private long totalSize;

	/**
	 * 页码总数
	 */
	private int totalPages;

	/**
	 * 分页数据
	 */
	private List<?> content;

	public PageResult() {

	}

	public PageResult(int pageNum, int pageSize, long totalSize, int totalPages, List<?> content) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalPages = totalPages;
		this.content = content;
	}

	public PageResult(int pageNum, int pageSize, long totalSize, int totalPages) {
		this(pageNum, pageSize, totalSize, totalPages, Collections.emptyList());
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

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<?> getContent() {
		return content;
	}

	public void setContent(List<?> content) {
		this.content = content;
	}
}
