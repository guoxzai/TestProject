package com.gxz.sys.vo;

import com.gxz.sys.domain.Permission;

public class PermissionVo extends Permission {

	private Integer page;
	private Integer limit;

	private String batchIds;

	public String getBatchIds() {
		return batchIds;
	}

	public void setBatchIds(String batchIds) {
		this.batchIds = batchIds;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
