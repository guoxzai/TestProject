package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Goods;
import com.gxz.bus.domain.Outport;
import com.gxz.bus.mapper.GoodsMapper;
import com.gxz.bus.mapper.OutportMapper;
import com.gxz.bus.service.OutportService;
import com.gxz.bus.vo.OutportVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class OutportServiceImpl implements OutportService {

	@Autowired
	private OutportMapper outportMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public DataGridView queryAllOutport(OutportVo outportVo) {
		Page<Object> page = PageHelper.startPage(outportVo.getPage(), outportVo.getLimit());
		List<Outport> data = outportMapper.queryAllOutport(outportVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addOutport(OutportVo outportVo) {
		Goods goods = goodsMapper.selectByPrimaryKey(outportVo.getGoodsid());
		Integer goodsNum = goods.getNumber();
		Integer outportNum = outportVo.getNumber();
		if(goodsNum>0 && goodsNum>=outportNum) {
			outportMapper.insertSelective(outportVo);
			goods.setId(outportVo.getGoodsid());goods.setNumber(goodsNum-outportNum);
			goodsMapper.updateByPrimaryKeySelective(goods);
		}
	}

	@Override
	public void deleteOutport(OutportVo outportVo) {
		Goods goods = goodsMapper.selectByPrimaryKey(outportVo.getGoodsid());
		Integer goodsNum = goods.getNumber();
		Integer outportNum = outportVo.getNumber();
		
		goods.setId(outportVo.getGoodsid());;goods.setNumber(goodsNum+outportNum);
		goodsMapper.updateByPrimaryKey(goods);
		outportMapper.deleteByPrimaryKey(outportVo.getId());
	}

}
