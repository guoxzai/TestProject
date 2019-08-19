package com.gxz.bus.service;

import java.util.List;

import com.gxz.bus.domain.Goods;
import com.gxz.bus.vo.GoodsVo;
import com.gxz.sys.utils.json.DataGridView;

public interface GoodsService {
	DataGridView queryAllGoods(GoodsVo goodsVo);
	
	Goods queryGoodsById(Integer goodsId);
	
	void addGoods(GoodsVo goodsVo);
	
	void updateGoods(GoodsVo goodsVo);
	
	void deleteGoods(Integer goodsId);

	//进货管理
	List<Goods> queryGoodsByProviderId(GoodsVo goodsVo);

	//商品销售
	List<Goods> loadAllGoodsForList(GoodsVo goodsVo);

	List<Goods> queryAllDangerNumber(GoodsVo goodsVo);

	
}
