package com.gxz.bus.vo;

import com.gxz.bus.domain.Sales;

public class SalesVo extends Sales {

	private Integer page;
	private Integer limit;

	private String batchIds;

	// 修改销售
	private Integer oldNumber;

	public Integer getOldNumber() {
		return oldNumber;
	}

	public void setOldNumber(Integer oldNumber) {
		this.oldNumber = oldNumber;
	}

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
