package com.gxz.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.service.LoginInfoService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.vo.LoginInfoVo;

@RestController
@RequestMapping("loginInfo")
public class LoginInfoController {

	@Autowired
	private LoginInfoService loginInfoService;
	
	@RequestMapping("loadAllLoginInfo")
	public DataGridView loadAllLoginInfo(LoginInfoVo loginInfoVo) {
		return loginInfoService.queryAllLoginInfo(loginInfoVo);
	}
	
	@RequestMapping("deleteLoginInfo")
	public ResultObj deleteLoginInfo(LoginInfoVo loginInfoVo) {
		ResultObj resultObj = null;
		try {
			loginInfoService.deleteLoginInfo(loginInfoVo.getId());
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("batchDeleteLoginInfo")
	public ResultObj batchDeleteLoginInfo(LoginInfoVo loginInfoVo) {
		String[] ids = loginInfoVo.getBatchIds().split(",");
		ResultObj resultObj = null;
		try {
			for (String id : ids) {
				loginInfoService.deleteLoginInfo(Integer.parseInt(id));
			}
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	} 
}
