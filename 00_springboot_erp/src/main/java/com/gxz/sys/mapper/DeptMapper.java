package com.gxz.sys.mapper;

import java.util.List;

import com.gxz.sys.domain.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    List<Dept> queryAllDept(Dept dept);
    
    Integer queryDeptChildren(Integer id);
}