package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.LoginInfo;
import com.gxz.sys.mapper.LoginInfoMapper;
import com.gxz.sys.service.LoginInfoService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.LoginInfoVo;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;

	@Override
	public DataGridView queryAllLoginInfo(LoginInfoVo loginInfoVo) {
		Page<Object> page = PageHelper.startPage(loginInfoVo.getPage(), loginInfoVo.getLimit());
		List<LoginInfo> data = loginInfoMapper.queryAllLoginInfo(loginInfoVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addLoginInfo(LoginInfoVo loginInfoVo) {
		loginInfoMapper.insertSelective(loginInfoVo);
	}

	@Override
	public void deleteLoginInfo(Integer loginInfoId) {
		loginInfoMapper.deleteByPrimaryKey(loginInfoId);
	}

}
