package com.gxz.sys.service;


import java.util.List;

import com.gxz.sys.domain.Role;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.RoleVo;
import com.gxz.sys.vo.UserVo;

public interface RoleService {
	DataGridView queryAllRightDataGrid(RoleVo roleVo);
	void addRole(RoleVo roleVo);
	void updateRole(RoleVo roleVo);
	void deleteRole(RoleVo roleVo);
	
	//角色分配权限
	void saveRolePermission(RoleVo roleVo);
	
	/**
	 * 用户分配角色
	 * @param roleVo
	 * @return
	 */
	List<Role> queryAllRole(RoleVo roleVo);
	List<Role> queryUserRoleByUid(UserVo userVo);
}
