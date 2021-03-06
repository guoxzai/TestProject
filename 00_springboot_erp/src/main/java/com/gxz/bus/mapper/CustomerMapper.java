package com.gxz.bus.mapper;

import java.util.List;

import com.gxz.bus.domain.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> queryAllCustomer(Customer customer);
}