package com.ym.common.model;

import java.util.List;

/**
 * 公共响应
 * 
 * @author xfz
 * 
 */
public class BaseQueryResp<T> extends BaseResp {
	/** 总页数 */
	private int pages;
	/** 总记录数 */
	private long totalCount;
	/** 当前页数 */
	private int pageNum;
	/** 每页显示数量 */
	private int pageSize;
	/** 返回数据集 */
	private List<T> results;

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
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

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
