package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Goods;
import com.gxz.bus.domain.Inport;
import com.gxz.bus.mapper.GoodsMapper;
import com.gxz.bus.mapper.InportMapper;
import com.gxz.bus.service.InportService;
import com.gxz.bus.vo.InportVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class InportServiceImpl implements InportService {

	@Autowired
	private InportMapper inportMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public DataGridView queryAllInport(InportVo inportVo) {
		Page<Object> page = PageHelper.startPage(inportVo.getPage(), inportVo.getLimit());
		List<Inport> data = inportMapper.queryAllInport(inportVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addInport(InportVo inportVo) {
		Integer inportNum = inportVo.getNumber();
		Goods goods = goodsMapper.selectByPrimaryKey(inportVo.getGoodsid());
		Integer goodsNum = goods.getNumber();
		goods.setId(inportVo.getGoodsid()); goods.setNumber(goodsNum+inportNum);
		goodsMapper.updateByPrimaryKeySelective(goods);
		
		inportMapper.insertSelective(inportVo);
	}

	@Override
	public void deleteInport(InportVo inportVo) {
		Integer inportNum = inportVo.getNumber();
		Goods goods = goodsMapper.selectByPrimaryKey(inportVo.getGoodsid());
		Integer goodsNum = goods.getNumber();
		if(goodsNum>0 && goodsNum>=inportNum) {
			goods.setId(inportVo.getGoodsid()); goods.setNumber(goodsNum-inportNum);
			goodsMapper.updateByPrimaryKeySelective(goods);
		}
		
		inportMapper.deleteByPrimaryKey(inportVo.getId());
	}

}
