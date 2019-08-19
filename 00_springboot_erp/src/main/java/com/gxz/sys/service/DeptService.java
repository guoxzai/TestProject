package com.gxz.sys.service;

import java.util.List;

import com.gxz.sys.domain.Dept;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.DeptVo;

public interface DeptService {

	//查询左边的zTree树
	List<Dept> queryAllLeftDept(DeptVo deptVo);
	//1>查询右边的数据表格  2>点击树的id查询下面的子菜单 
	DataGridView queryAllRightDept(DeptVo deptVo);
	
	void addDept(DeptVo deptVo);
	void updateDept(DeptVo deptVo);
	
	//判断文件夹下是否还有文件
	Integer queryDeptChildren(Integer id);
	void deleteDeptById(Integer id);
}
