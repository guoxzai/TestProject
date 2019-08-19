package com.gxz.bus.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.bus.service.InportService;
import com.gxz.bus.vo.GoodsVo;
import com.gxz.bus.vo.InportVo;
import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.User;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;

@RestController
@RequestMapping("inport")
public class InportController {

	@Autowired
	private InportService inportService;
	
	@RequestMapping("loadAllInport")
	public DataGridView loadAllInport(InportVo inportVo) {
		return inportService.queryAllInport(inportVo);
	}
	
	@RequestMapping("addInport")
	public ResultObj addInport(InportVo inportVo) {
		inportVo.setInporttime(new Timestamp(System.currentTimeMillis()));
		User user = (User) WebUtils.getCurrentSession().getAttribute("user");
		inportVo.setOperateperson(user.getName());
		ResultObj resultObj = null;
		try {
			inportService.addInport(inportVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteInport")
	public ResultObj deleteInport(InportVo inportVo) {
		ResultObj resultObj = null;
		try {
			inportService.deleteInport(inportVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	
}
