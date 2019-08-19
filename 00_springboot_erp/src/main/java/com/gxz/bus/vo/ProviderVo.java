package com.gxz.bus.vo;

import com.gxz.bus.domain.Provider;

public class ProviderVo extends Provider {

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
