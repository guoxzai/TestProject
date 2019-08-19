package com.gxz.sys.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.Permission;
import com.gxz.sys.service.PermissionService;
import com.gxz.sys.service.RoleService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.utils.json.TreeNode;
import com.gxz.sys.vo.PermissionVo;
import com.gxz.sys.vo.RoleVo;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("loadAllRole")
	public DataGridView loadAllRole(RoleVo roleVo) {
		return roleService.queryAllRightDataGrid(roleVo);
	}

	@RequestMapping("addRole")
	public ResultObj addRole(RoleVo roleVo) {
		ResultObj obj = null;
		try {
			roleService.addRole(roleVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		return obj;
	}

	@RequestMapping("updateRole")
	public ResultObj updateRole(RoleVo roleVo) {
		ResultObj obj = null;
		try {
			roleService.updateRole(roleVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		return obj;
	}
	
	@RequestMapping("deleteRole")
	public ResultObj deleteRole(RoleVo roleVo) {
		ResultObj obj = null;
		try {
			roleService.deleteRole(roleVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		return obj;
	}
	
	//批量删除角色
	@RequestMapping("batchDeleteRole")
	public ResultObj batchDeleteRole(RoleVo roleVo) {
	    String[] ids = roleVo.getBatchIds().split(",");
		
		ResultObj obj = null;
		try {
			for (String id : ids) {
				roleVo.setId(Integer.parseInt(id));
				roleService.deleteRole(roleVo);
			}
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		return obj;
	} 
	
	
	@RequestMapping("selectRolePermission")
	public List<TreeNode> selectRolePermission(RoleVo roleVo){
		PermissionVo permissionVo = new PermissionVo();
		permissionVo.setAvailable(SYSConstast.SYS_MENU_AVAILABLE_TRUE);
		List<Permission> permissionsAll = permissionService.queryAllPermission(permissionVo);
		List<Permission> permissionsRole = permissionService.queryPermissionByRoleId(roleVo.getId());
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		
		for (Permission p1 : permissionsAll) {
			boolean checked = false;
			
			for (Permission p2 : permissionsRole) {
				if(p1.getId() == p2.getId()) {
					checked = true;
					break;
				}
				
			}
			
			Boolean isParent = p1.getType().equals(SYSConstast.SYS_TYPE_MENU)?true:false;
			Boolean open = p1.getOpen()==SYSConstast.SYS_MENU_OPEN_TRUE?true:false;
			nodes.add(new TreeNode(p1.getId(), p1.getPid(), p1.getName(), isParent, open, checked));
		}
		return nodes;
	}
	
	@RequestMapping("saveRolePermission")
	public ResultObj saveRolePermission(RoleVo roleVo) {
		ResultObj obj = null;
		try {
			roleService.saveRolePermission(roleVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_PERMISSION_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_PERMISSION_ERROR);
		}
		return obj;
	}

}
