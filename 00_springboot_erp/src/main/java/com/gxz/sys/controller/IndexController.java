package com.gxz.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

	/**
	 * 去首页   前台的桌面界面
	 * @return
	 */
	@RequestMapping("toDeskManager")
	public String toDeskManager() {
		return "deskManager";
	}
	
	/**
	 * 去日志管理界面
	 */
	@RequestMapping("toLogInfoManager")
	public String toLoginInfoManager() {
		return "system/loginInfoManager";
	}
	
	/**
	 * 去系统公告界面
	 */
	@RequestMapping("toNoticeManager")
	public String toNoticeManager() {
		return "system/noticeManager";
	}
	
	/**
	 * 去部门管理界面
	 */
	@RequestMapping("toDeptManager")
	public String toDeptManager() {
		return "system/dept/deptManager";
	}
	
	@RequestMapping("toDeptLeftManager")
	public String toDeptLeftManager() {
		return "system/dept/deptManagerLeft";
	}
	
	@RequestMapping("toDeptRightManager")
	public String toDeptRightManager() {
		return "system/dept/deptManagerRight";
	}
	
	/**
	 * 去菜单管理界面
	 */
	@RequestMapping("toMenuManager")
	public String toMenuManager() {
		return "system/menu/menuManager";
	}
	
	@RequestMapping("toMenuLeftManager")
	public String toMenuLeftManager() {
		return "system/menu/menuManagerLeft";
	}
	
	@RequestMapping("toMenuRightManager")
	public String toMenuRightManager() {
		return "system/menu/menuManagerRight";
	}
	
	/**
	 * 去权限管理界面
	 */
	@RequestMapping("toPermissionManager")
	public String toPermissionManager() {
		return "system/permission/permissionManager";
	}
	
	@RequestMapping("toPermissionLeftManager")
	public String toPermissionLeftManager() {
		return "system/permission/permissionManagerLeft";
	}
	
	@RequestMapping("toPermissionRightManager")
	public String toPermissionRightManager() {
		return "system/permission/permissionManagerRight";
	}
	
	/**
	 * 去角色管理界面
	 */
	@RequestMapping("toRoleManager")
	public String toRoleManager() {
		return "system/role/roleManager";
	}
	
	/**
	 * 去用户管理界面
	 */
	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "system/user/userManager";
	}
	
	@RequestMapping("toUserLeftManager")
	public String toUserLeftManager() {
		return "system/user/userManagerLeft";
	}
	
	@RequestMapping("toUserRightManager")
	public String toUserRightManager() {
		return "system/user/userManagerRight";
	}
	
	
}
