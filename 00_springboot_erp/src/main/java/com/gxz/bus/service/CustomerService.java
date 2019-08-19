package com.gxz.bus.service;

import java.util.List;

import com.gxz.bus.domain.Customer;
import com.gxz.bus.vo.CustomerVo;
import com.gxz.sys.utils.json.DataGridView;

public interface CustomerService {
	
	DataGridView queryAllCustomer(CustomerVo customerVo);
	
	void addCustomer(CustomerVo customerVo);
	
	void updateCustomer(CustomerVo customerVo);
	
	void deleteCustomer(Integer customerId);

	List<Customer> loadAllCustomerForList(CustomerVo customerVo);
}
