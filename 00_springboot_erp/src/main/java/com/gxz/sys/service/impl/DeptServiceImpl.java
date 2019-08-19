package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.Dept;
import com.gxz.sys.mapper.DeptMapper;
import com.gxz.sys.service.DeptService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.DeptVo;


@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> queryAllLeftDept(DeptVo deptVo) {
		return deptMapper.queryAllDept(deptVo);
	}

	@Override
	public DataGridView queryAllRightDept(DeptVo deptVo) {
		Page<Object> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());
		List<Dept> data = deptMapper.queryAllDept(deptVo);
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addDept(DeptVo deptVo) {
		deptMapper.insertSelective(deptVo);
	}

	@Override
	public void updateDept(DeptVo deptVo) {
		deptMapper.updateByPrimaryKeySelective(deptVo);
	}

	@Override
	public Integer queryDeptChildren(Integer id) {
		return deptMapper.queryDeptChildren(id);
	}

	@Override
	public void deleteDeptById(Integer id) {
		deptMapper.deleteByPrimaryKey(id);
	}
	
}
