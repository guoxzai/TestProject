package com.gxz.bus.mapper;

import java.util.List;

import com.gxz.bus.domain.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> queryAllGoods(Goods goods);
    
    //桌面上查询预警库存
    List<Goods> queryAllDangerNumber(Goods goods);
}