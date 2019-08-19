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
import com.gxz.sys.domain.User;
import com.gxz.sys.service.PermissionService;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.utils.json.BuilderTreeNode;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.utils.json.TreeNode;
import com.gxz.sys.vo.PermissionVo;

@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private PermissionService permissionService;

	
	@RequestMapping("loadIndexLeftTreeJson")
	public List<TreeNode> loadIndexLeftTreeJson(PermissionVo permissionVo){
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		User user = (User) WebUtils.getCurrentSession().getAttribute("user");
		permissionVo.setType(SYSConstast.SYS_TYPE_MENU);
		permissionVo.setAvailable(SYSConstast.SYS_MENU_AVAILABLE_TRUE);
		
		List<Permission> permissions = null;
		if(user.getType()==SYSConstast.USER_TYPE_SUPER) {
			permissions =  permissionService.queryAllPermission(permissionVo);
		}else{
			permissions = permissionService.queryPermissionByUserId(SYSConstast.SYS_TYPE_MENU,user.getId());
		}
		
		for (Permission permission : permissions) {
			Integer id = permission.getId();
			Integer pid = permission.getPid();
			String title = permission.getName();
			String icon = permission.getIcon();
			String href = permission.getHref();
			Boolean spread = permission.getOpen()==SYSConstast.SYS_OPEN_TRUE?true:false;
			nodes.add(new TreeNode(id, pid, title, icon, href, spread));
		}
		
		List<TreeNode> nodesJson = BuilderTreeNode.builderChildersTreeNode(nodes, 1);
		return nodesJson;
	}
	
	/****菜单管理开始*******/
	@RequestMapping("loadAllLeftMenuJsonTree")
	public List<TreeNode> loadAllLeftMenuJsonTree(PermissionVo permissionVo){
		permissionVo.setAvailable(SYSConstast.SYS_MENU_AVAILABLE_TRUE);
		List<TreeNode> nodes = new ArrayList<>();
		List<Permission> permissions = permissionService.queryAllPermission(permissionVo);
		for (Permission permission : permissions) {
			Integer id = permission.getId();
			Integer pid = permission.getPid();
			String name = permission.getName();
			Boolean isParent = permission.getParent()==SYSConstast.SYS_MENU_ISPARENT_TRUE?true:false;
			Boolean open = permission.getOpen() == SYSConstast.SYS_MENU_OPEN_TRUE?true:false;
			nodes.add(new TreeNode(id, pid, name, isParent, open));
		}
		
		return nodes;
	}
	
	@RequestMapping("loadAllRightMenu")
	public DataGridView loadAllRightMenu(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_MENU);
		return permissionService.queryAllRightDataGrid(permissionVo);
	}
	
	@RequestMapping("addMenu")
	public ResultObj addMenu(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_MENU);
		
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
	
	@RequestMapping("updateMenu")
	public ResultObj updateMenu(PermissionVo permissionVo) {
		permissionVo.setType(SYSConstast.SYS_TYPE_MENU);
		
		ResultObj obj = null;
		try {
			permissionService.updatePermission(permissionVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		return obj;
	}
	
	@RequestMapping("isExistChildren")
	public  Map<String,Object> isExistChildren(PermissionVo permissionVo){
		Map<String,Object> map = new HashMap<>();
		Integer childrenCount = permissionService.queryPermissionChildren(permissionVo.getId());
		boolean flag = childrenCount>0?true:false;
		map.put("value", flag);
		return map;
	}
	
	@RequestMapping("deleteMenuById")
	public ResultObj deleteMenuById(PermissionVo permissionVo) {
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
	
	/****菜单管理结束*******/
	
}
