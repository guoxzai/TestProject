package com.gxz.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.bus.service.SalesService;
import com.gxz.bus.utils.GoodsNumberException;
import com.gxz.bus.vo.CustomerVo;
import com.gxz.bus.vo.ProviderVo;
import com.gxz.bus.vo.SalesVo;
import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.User;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;

@RestController
@RequestMapping("sales")
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	@RequestMapping("loadAllRightSales")
	private DataGridView loadAllSales(SalesVo salesVo) {
		return salesService.queryAllSales(salesVo);
	}
	
	@RequestMapping("addSales")
	public ResultObj addSales(SalesVo salesVo) {
		User user = (User) WebUtils.getCurrentSession().getAttribute("user");
		salesVo.setOperateperson(user.getName());
		
		ResultObj resultObj = null;
		try {
			salesService.addSales(salesVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
			
		}catch(GoodsNumberException e) {
			System.out.println(e.getMsg());
			resultObj = new ResultObj(0,SYSConstast.SYS_GOODS_NUMBER);
			
		}catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
			
		}
		
		return resultObj;
	}
	
	@RequestMapping("updateSales")
	public ResultObj updateSales(SalesVo salesVo) {
		User user = (User) WebUtils.getCurrentSession().getAttribute("user");
		salesVo.setOperateperson(user.getName());
		
		ResultObj resultObj = null;
		try {
			salesService.updateSales(salesVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteSales")
	public ResultObj deleteSales(SalesVo salesVo) {
		ResultObj resultObj = null;
		try {
			salesService.deleteSales(salesVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("batchDeleteSales")
	public ResultObj batchDeleteSales(SalesVo salesVo) {
		String batchIds = salesVo.getBatchIds();
		String[] ids = batchIds.split(",");
		ResultObj resultObj = null;
		try {
			for (String id : ids) {
				salesVo.setId(Integer.parseInt(id));
				salesService.deleteSales(salesVo);
			}
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
}
