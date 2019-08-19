package com.gxz.bus.mapper;

import java.util.List;

import com.gxz.bus.domain.Inport;

public interface InportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inport record);

    int insertSelective(Inport record);

    Inport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inport record);

    int updateByPrimaryKey(Inport record);
    
    List<Inport> queryAllInport(Inport inport);
}