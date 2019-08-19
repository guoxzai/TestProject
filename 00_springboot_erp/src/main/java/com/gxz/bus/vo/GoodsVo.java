package com.gxz.bus.vo;

import com.gxz.bus.domain.Goods;

public class GoodsVo extends Goods {

	private Integer page;
	private Integer limit;

	private String batchIds;
	
	private String goodsimgs;
	
	public String getGoodsimgs() {
		return goodsimgs;
	}

	public void setGoodsimgs(String goodsimgs) {
		this.goodsimgs = goodsimgs;
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
