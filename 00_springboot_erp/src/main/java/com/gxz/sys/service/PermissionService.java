package com.gxz.sys.service;

import java.util.List;

import com.gxz.sys.domain.Permission;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.PermissionVo;

public interface PermissionService {
	//查询所有菜单
	List<Permission> queryAllPermission(PermissionVo permissionVo);
	//根据用户ID查询菜单
	
	DataGridView queryAllRightDataGrid(PermissionVo permissionVo);

	void addPermission(PermissionVo permissionVo);
	void updatePermission(PermissionVo permissionVo);

	Integer queryPermissionChildren(Integer id);

	void deletePermission(PermissionVo permissionVo);

	/**
	 * 根据角色ID查询出相应的权限
	 * @param id
	 * @return
	 */
	List<Permission> queryPermissionByRoleId(Integer rid);
	
	/*************主页面根据用户ID查询显示的菜单******************/
	List<Permission> queryPermissionByUserId(String sysTypePermission, Integer id);
}
