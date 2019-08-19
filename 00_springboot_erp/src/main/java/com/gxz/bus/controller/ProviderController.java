package com.gxz.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.bus.domain.Provider;
import com.gxz.bus.service.ProviderService;
import com.gxz.bus.vo.ProviderVo;
import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;

@RestController
@RequestMapping("provider")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("loadAllProvider")
	public DataGridView loadAllProvider(ProviderVo providerVo) {
		return providerService.queryAllProvider(providerVo);
	}
	
	@RequestMapping("loadAllProviderForList")
	public List<Provider> loadAllProviderForList(ProviderVo providerVo){
		return providerService.queryAllProviderForList(providerVo);
	}
	
 	
	@RequestMapping("addProvider")
	public ResultObj addProvider(ProviderVo providerVo) {
		ResultObj resultObj = null;
		try {
			providerService.addProvider(providerVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("updateProvider")
	public ResultObj updateProvider(ProviderVo providerVo) {
		ResultObj resultObj = null;
		try {
			providerService.updateProvider(providerVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteProvider")
	public ResultObj deleteProvider(ProviderVo providerVo) {
		ResultObj resultObj = null;
		try {
			providerService.deleteProvider(providerVo.getId());
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("batchDeleteProvider")
	public ResultObj batchDeleteProvider(ProviderVo providerVo) {
		String batchIds = providerVo.getBatchIds();
		String[] ids = batchIds.split(",");
		ResultObj resultObj = null;
		try {
			for (String id : ids) {
				providerService.deleteProvider(Integer.parseInt(id));
			}
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
}
