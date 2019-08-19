package com.gxz.sys.utils.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeNode {
	/*****模板layui  提供树的navs.json格式         标准json格式   *****/
	private Integer id;
	@JsonProperty("pId")
	private Integer pid;
	private String title;
	private String icon;
	private String href;
	private Boolean spread;

	private List<TreeNode> children = new ArrayList<TreeNode>();

	/*** zTree树     dept——简单的json格式***/
	private String name;
	private Boolean isParent;
	private Boolean open;

	public TreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.isParent = isParent;
		this.open = open;
	}

	/*** zTree树的结束 ***/
	
	/**********角色分配的  checkbox树  开始*****************/
	private boolean checked;
	
	public TreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open, boolean checked) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.isParent = isParent;
		this.open = open;
		this.checked = checked;
	}

	/**********角色分配的  checkbox树  结束*****************/
	

	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.href = href;
		this.spread = spread;
	}

	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}
