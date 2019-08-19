package com.gxz.bus.service;

import com.gxz.bus.utils.GoodsNumberException;
import com.gxz.bus.vo.SalesVo;
import com.gxz.sys.utils.json.DataGridView;

public interface SalesService {

	DataGridView queryAllSales(SalesVo salesVo);

	void addSales(SalesVo salesVo) throws GoodsNumberException;

	void updateSales(SalesVo salesVo);

	void deleteSales(SalesVo salesVo);

}
