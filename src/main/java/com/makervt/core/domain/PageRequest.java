package com.makervt.core.domain;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 分页参数封装类.
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class PageRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 页码
	 */
	protected int pageNo = 1;
	
	/**
	 * 每页记录数
	 */
	protected int pageSize = 10;
	
	/**
	 * 排序字段
	 */
	protected String orderBy = null;
	
	/**
	 * 总页数
	 */
	protected int pageTotal=0;
	
	/**
	 * 总记录数
	 */
	protected int totalCount=0;
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	protected int start=0;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}


	public PageRequest() {
	}

	public PageRequest(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	/**
	 * 获得当前页的页号, 序号从1开始, 默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号, 序号从1开始, 低于1时自动调整为1.
	 */
	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * 获得每页的记录数量, 默认为10.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量, 低于1时自动调整为1.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	


	
	
}
