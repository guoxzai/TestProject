package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.Permission;
import com.gxz.sys.mapper.PermissionMapper;
import com.gxz.sys.service.PermissionService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.PermissionVo;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> queryAllPermission(PermissionVo permissionVo) {
		return permissionMapper.queryAllPermission(permissionVo);
	}

	@Override
	public DataGridView queryAllRightDataGrid(PermissionVo permissionVo) {
		Page<Object> page = PageHelper.startPage(permissionVo.getPage(), permissionVo.getLimit());
		List<Permission> data = permissionMapper.queryAllPermission(permissionVo);
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addPermission(PermissionVo permissionVo) {
		permissionMapper.insertSelective(permissionVo);
	}

	@Override
	public void updatePermission(PermissionVo permissionVo) {
		permissionMapper.updateByPrimaryKeySelective(permissionVo);
	}

	@Override
	public Integer queryPermissionChildren(Integer id) {
		return permissionMapper.queryPermissionChildren(id);
	}

	@Override
	public void deletePermission(PermissionVo permissionVo) {
		permissionMapper.deleteByPrimaryKey(permissionVo.getId());
	}

	@Override
	public List<Permission> queryPermissionByRoleId(Integer rid) {
		return permissionMapper.queryPermissionByRoleId(rid);
	}

	@Override
	public List<Permission> queryPermissionByUserId(String sysTypePermission, Integer uid) {
		return permissionMapper.queryPermissionByUserId(sysTypePermission,uid);
	}
}
