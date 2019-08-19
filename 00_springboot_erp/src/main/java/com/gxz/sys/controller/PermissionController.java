package com.gxz.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.Permission;
import com.gxz.sys.service.PermissionService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.utils.json.TreeNode;
import com.gxz.sys.vo.PermissionVo;

@RestController
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	/**** 权限管理开始 *******/
	@RequestMapping("loadAllLeftPermissionJsonTree")
	public List<TreeNode> loadAllLeftMenuJsonTree(PermissionVo permissionVo){
		permissionVo.setAvailable(SYSConstast.SYS_MENU_AVAILABLE_TRUE);
		List<TreeNode> nodes = new ArrayList<>();
		List<Permission> permissions = permissionService.queryAllPermission(permissionVo);
		for (Permission permission : permissions) {
			Integer id = permission.getId();
			Integer pid = permission.getPid();
			String name = permission.getName();
			Boolean isParent = permission.getType().equals(SYSConstast.SYS_TYPE_MENU)?true:false;
			Boolean open = permission.getOpen() == SYSConstast.SYS_MENU_OPEN_TRUE?true:false;
			nodes.add(new TreeNode(id, pid, name, isParent, open));
		}
		
		return nodes;
	}
	
	@RequestMapping("loadAllRightPermission")
	public DataGridView loadAllRightPermission(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_PERMISSION);
		return permissionService.queryAllRightDataGrid(permissionVo);
	}

	@RequestMapping("addPermission")
	public ResultObj addPermission(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_PERMISSION);

		ResultObj obj = null;
		try {
			permissionService.addPermission(permissionVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		return obj;
	}

	@RequestMapping("updatePermission")
	public ResultObj updatePermission(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_PERMISSION);

		ResultObj obj = null;
		try {
			permissionService.updatePermission(permissionVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		return obj;
	}

	@RequestMapping("isExistChildren")
	public Map<String, Object> isExistChildren(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		Integer childrenCount = permissionService.queryPermissionChildren(permissionVo.getId());
		boolean flag = childrenCount > 0 ? true : false;
		map.put("value", flag);
		return map;
	}

	@RequestMapping("deletePermissionById")
	public ResultObj deletePermissionById(PermissionVo permissionVo) {
		ResultObj obj = null;
		try {
			permissionService.deletePermission(permissionVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		return obj;
	}
	
	//批量删除权限
	@RequestMapping("batchDeletePermission")
	public ResultObj batchDeletePermission(PermissionVo permissionVo) {
		String[] ids = permissionVo.getBatchIds().split(",");
		
		ResultObj obj = null;
		try {
			for (String id : ids) {
				permissionVo.setId(Integer.parseInt(id));
				permissionService.deletePermission(permissionVo);
			}
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		return obj;
	}

	/**** 权限管理结束 *******/
}
