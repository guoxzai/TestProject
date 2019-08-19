package com.gxz.sys.constast;

public interface SYSConstast {
	/**
	 *  用户身份判断 
	 */
	Integer USER_TYPE_NORMAL=1;
	Integer USER_TYPE_SUPER=0;
	
	/**
	 * 菜单显示
	 */
	String SYS_TYPE_MENU = "menu";
	String SYS_TYPE_PERMISSION = "permission";
	
	Integer SYS_MENU_AVAILABLE_TRUE = 1;
	Integer SYS_MENU_AVAILABLE_FALSE = 0;
	
	Integer SYS_OPEN_TRUE = 1;
	Integer SYS_OPEN_FALSE = 0;
	
	/**
	 * 操作提示
	 */
	String SYS_OPTION_ADD_SUCCESS = "添加成功";
	String SYS_OPTION_ADD_ERROR = "添加失败";
	
	String SYS_OPTION_UPDATE_SUCCESS = "修改成功";
	String SYS_OPTION_UPDATE_ERROR = "修改成功";
	
	String SYS_OPTION_DELETE_SUCCESS = "删除成功";
	String SYS_OPTION_DELETE_ERROR = "删除失败";
	
	/**
	 * 部门菜单管理
	 */
	Integer SYS_DEPT_ISPARENT_TRUE = 1;
	Integer SYS_DEPT_ISPARENT_FALSE = 0;
	Integer SYS_DEPT_OPEN_TRUE = 1;
	Integer SYS_DEPT_OPEN_FALSE = 0;
	
	/**
	 * 菜单管理
	 */
	Integer SYS_MENU_ISPARENT_TRUE = 1;
	Integer SYS_MENU_ISPARENT_FALSE = 0;
	Integer SYS_MENU_OPEN_TRUE = 1;
	Integer SYS_MENU_OPEN_FALSE = 0;
	
	/**
	 * 角色管理
	 */
	String SYS_OPTION_PERMISSION_SUCCESS = "分配权限成功";
	String SYS_OPTION_PERMISSION_ERROR = "分配权限失败";
	
	Integer SYS_ROLE_AVAILABLE_TRUE = 1;
	Integer SYS_ROLE_AVAILABLE_FALSE = 0;
	
	/**
	 * 用户管理
	 */
	//默认信息
	String SYS_USER_DEFAULT_PWD = "123456";
	String SYS_USER_DEFAULT_IMG = "../resources/images/defaultusertitle.jpg";
	//用户身份
	Integer SYS_USER_TYPE_NORAML = 1;
	Integer SYS_USER_TYPE_SUPER = 0;
	//密码重置提示
	String SYS_USER_RESET_SUCCESS="重置密码成功";
	String SYS_USER_RESET_ERROR="重置密码失败";
	//分配角色
	String SYS_OPTION_ROLE_SUCCESS = "分配角色成功";
	String SYS_OPTION_ROLE_ERROR = "分配角色失败";
	
	String SYS_GOODS_NUMBER = "库存不足";
}
