package com.gxz.bus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.bus.domain.Customer;
import com.gxz.bus.service.CustomerService;
import com.gxz.bus.vo.CustomerVo;
import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.utils.json.TreeNode;


@RestController	 	
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("loadAllCustomer")
	public DataGridView loadAllCustomer(CustomerVo customerVo) {
		return customerService.queryAllCustomer(customerVo);
	}
	
	@RequestMapping("addCustomer")
	public ResultObj addCustomer(CustomerVo customerVo) {
		ResultObj resultObj = null;
		try {
			customerService.addCustomer(customerVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("updateCustomer")
	public ResultObj updateCustomer(CustomerVo customerVo) {
		ResultObj resultObj = null;
		try {
			customerService.updateCustomer(customerVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteCustomer")
	public ResultObj deleteCustomer(CustomerVo customerVo) {
		ResultObj resultObj = null;
		try {
			customerService.deleteCustomer(customerVo.getId());
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("batchDeleteCustomer")
	public ResultObj batchDeleteCustomer(CustomerVo customerVo) {
		String batchIds = customerVo.getBatchIds();
		String[] ids = batchIds.split(",");
		ResultObj resultObj = null;
		try {
			for (String id : ids) {
				customerService.deleteCustomer(Integer.parseInt(id));
			}
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	
	/**
	 * 销售左边客户树
	 */
	@RequestMapping("loadAllCustomerLeftJsonTree")
	public List<TreeNode> loadAllCustomerLeftJsonTree(CustomerVo customerVo){
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(new TreeNode(null, 0, "所有客户", true, true));
		List<Customer> customers = customerService.loadAllCustomerForList(customerVo);
		for (Customer customer : customers) {
			Integer id = customer.getId();
			Integer pid = null;
			String name = customer.getCustomername();
			Boolean isParent = false;
			Boolean open = false;
			nodes.add(new TreeNode(id, pid, name, isParent, open));
		}
		
		return nodes;
	}
	
	@RequestMapping("loadAllCustomerForList")
	public List<Customer> loadAllCustomerForList(CustomerVo customerVo){
		return customerService.loadAllCustomerForList(customerVo);
	}
}
