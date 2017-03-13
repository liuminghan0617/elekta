package com.makervt.core.domain;

import java.util.List;

/**
 * 常用树形结构参数封装
 * 
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-5-29 下午4:57:18
 */
public class Tree {
	/**
	 * 标识
	 */
	private String id;
	
	/**
	 * 名称
	 */
	private String text;
	
	/**
	 * 是否为叶子节点
	 */
	private boolean leaf;
	
	/**
	 * 图标样式
	 */
	private String cls;
	
	/**
	 * 节点链接
	 */
	private String url;
	
	/**
	 * 备注
	 */
	private String remark;
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private boolean expanded;

	/*
	 * public boolean getChecked() { return checked; } public void
	 * setChecked(boolean checked) { this.checked = checked; } private boolean
	 * checked ;
	 */

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private List<Tree> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public List<Tree> getChildren() {
		return children;
	}
	
	public void setChildren(List<Tree> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", leaf=" + leaf
				+ ", cls=" + cls + ", url=" + url + ", children="
				+ children + "]";
	}

}
