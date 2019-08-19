package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Customer;
import com.gxz.bus.mapper.CustomerMapper;
import com.gxz.bus.service.CustomerService;
import com.gxz.bus.vo.CustomerVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public DataGridView queryAllCustomer(CustomerVo customerVo) {
		Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
		List<Customer> data = customerMapper.queryAllCustomer(customerVo);
		return new DataGridView(page.getTotal(), data);
	}
	
	@Override
	public List<Customer> loadAllCustomerForList(CustomerVo customerVo) {
		return customerMapper.queryAllCustomer(customerVo);
	}

	@Override
	public void addCustomer(CustomerVo customerVo) {
		customerMapper.insertSelective(customerVo);
	}

	@Override
	public void updateCustomer(CustomerVo customerVo) {
		customerMapper.updateByPrimaryKeySelective(customerVo);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerMapper.deleteByPrimaryKey(customerId);
	}

}
