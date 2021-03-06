package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Goods;
import com.gxz.bus.mapper.GoodsMapper;
import com.gxz.bus.service.GoodsService;
import com.gxz.bus.vo.GoodsVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public DataGridView queryAllGoods(GoodsVo goodsVo) {
		Page<Object> page = PageHelper.startPage(goodsVo.getPage(), goodsVo.getLimit());
		List<Goods> data = goodsMapper.queryAllGoods(goodsVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addGoods(GoodsVo goodsVo) {
		goodsMapper.insertSelective(goodsVo);
	}

	@Override
	public void updateGoods(GoodsVo goodsVo) {
		goodsMapper.updateByPrimaryKeySelective(goodsVo);
	}

	@Override
	public void deleteGoods(Integer goodsId) {
		goodsMapper.deleteByPrimaryKey(goodsId);
	}

	@Override
	public Goods queryGoodsById(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	public List<Goods> queryGoodsByProviderId(GoodsVo goodsVo) {
		return goodsMapper.queryAllGoods(goodsVo);
	}

	@Override
	public List<Goods> loadAllGoodsForList(GoodsVo goodsVo) {
		return goodsMapper.queryAllGoods(goodsVo);
	}

	@Override
	public List<Goods> queryAllDangerNumber(GoodsVo goodsVo) {
		return goodsMapper.queryAllDangerNumber(goodsVo);
	}

}
