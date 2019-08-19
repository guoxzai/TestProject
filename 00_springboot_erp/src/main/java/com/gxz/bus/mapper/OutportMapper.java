package com.gxz.bus.mapper;

import java.util.List;

import com.gxz.bus.domain.Outport;

public interface OutportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outport record);

    int insertSelective(Outport record);

    Outport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outport record);

    int updateByPrimaryKey(Outport record);
    
    List<Outport> queryAllOutport(Outport outport);
}