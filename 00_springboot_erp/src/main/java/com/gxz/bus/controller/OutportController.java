package com.gxz.bus.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.bus.service.OutportService;
import com.gxz.bus.vo.InportVo;
import com.gxz.bus.vo.OutportVo;
import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.User;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;

@RestController
@RequestMapping("outport")
public class OutportController {

	@Autowired
	private OutportService outportService;
	
	@RequestMapping("loadAllOutport")
	public DataGridView loadAllOutport(OutportVo outportVo) {
		return outportService.queryAllOutport(outportVo);
	}
	
	@RequestMapping("addOutport")
	public ResultObj addOutport(OutportVo outportVo) {
		outportVo.setOutporttime(new Timestamp(System.currentTimeMillis()));
		User user = (User) WebUtils.getCurrentSession().getAttribute("user");
		outportVo.setOperateperson(user.getName());
		ResultObj resultObj = null;
		try {
			outportService.addOutport(outportVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteOutport")
	public ResultObj deleteOutport(OutportVo outportVo) {
		ResultObj resultObj = null;
		try {
			outportService.deleteOutport(outportVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
}
