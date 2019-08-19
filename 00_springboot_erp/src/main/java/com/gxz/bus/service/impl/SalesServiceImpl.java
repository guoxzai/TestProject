package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Goods;
import com.gxz.bus.domain.Sales;
import com.gxz.bus.mapper.GoodsMapper;
import com.gxz.bus.mapper.SalesMapper;
import com.gxz.bus.service.SalesService;
import com.gxz.bus.utils.GoodsNumberException;
import com.gxz.bus.vo.SalesVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesMapper salesMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public DataGridView queryAllSales(SalesVo salesVo) {
		Page<Object> page = PageHelper.startPage(salesVo.getPage(), salesVo.getLimit());
		List<Sales> data = salesMapper.queryAllSales(salesVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addSales(SalesVo salesVo) throws GoodsNumberException {
		Goods goods = goodsMapper.selectByPrimaryKey(salesVo.getGoodsid());
		if(goods.getNumber() >= salesVo.getNumber()) {
			goods.setId(salesVo.getGoodsid());goods.setNumber(goods.getNumber()-salesVo.getNumber());
			goodsMapper.updateByPrimaryKeySelective(goods);
			salesMapper.insertSelective(salesVo);
		}else {
			throw new GoodsNumberException("超出库存");
		}
	}

	@Override
	public void updateSales(SalesVo salesVo){
		Goods goods = goodsMapper.selectByPrimaryKey(salesVo.getGoodsid());
		if(salesVo.getOldNumber()>salesVo.getNumber()) {
			goods.setId(salesVo.getGoodsid());
			goods.setNumber(goods.getNumber()+salesVo.getOldNumber()-salesVo.getNumber());
			goodsMapper.updateByPrimaryKeySelective(goods);
			
		}else if(salesVo.getOldNumber()<salesVo.getNumber()) {
			Integer goodsNumber = goods.getNumber()+salesVo.getOldNumber();
			if(goodsNumber >= salesVo.getNumber()) {
				goods.setId(salesVo.getGoodsid());
				goods.setNumber(goodsNumber-salesVo.getNumber());
				goodsMapper.updateByPrimaryKeySelective(goods);
			}
			
		}
		salesMapper.updateByPrimaryKeySelective(salesVo);
	}

	@Override
	public void deleteSales(SalesVo salesVo) {
		Goods goods = goodsMapper.selectByPrimaryKey(salesVo.getGoodsid());
		goods.setNumber(goods.getNumber()+salesVo.getNumber());
		goodsMapper.updateByPrimaryKeySelective(goods);
		
		salesMapper.deleteByPrimaryKey(salesVo.getId());
	}
	
}
