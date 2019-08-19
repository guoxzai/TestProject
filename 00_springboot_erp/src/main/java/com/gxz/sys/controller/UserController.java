package com.gxz.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.Dept;
import com.gxz.sys.domain.Role;
import com.gxz.sys.domain.User;
import com.gxz.sys.service.RoleService;
import com.gxz.sys.service.UserService;
import com.gxz.sys.utils.Md5Utils;
import com.gxz.sys.utils.PinYinUtils;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.utils.json.TreeNode;
import com.gxz.sys.vo.RoleVo;
import com.gxz.sys.vo.UserVo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
    @Autowired					
	private RoleService roleService;
	
	@RequestMapping("loadAllUser")
	public DataGridView loadAllUser(UserVo userVo) {
		return userService.queryAllRightDataGrid(userVo);
	}

	//角色的添加
	@RequestMapping("loadAllUserForList")
	public List<User> loadAllUserForList(UserVo userVo){
		return userService.loadAllUserForList(userVo);
	}
	
	@RequestMapping("nameConventToPingYin")
	public Map<String,Object> nameConventToPingYin(UserVo userVo){
		Map<String,Object> map = new HashMap<>();
		map.put("value", PinYinUtils.toPinyin(userVo.getName()));
		return map;
	}
	
	@RequestMapping("addUser")
	public ResultObj addUser(UserVo userVo) {
		String salt = Md5Utils.createRandomStr();
		userVo.setSalt(salt);
		userVo.setPwd(Md5Utils.md5(SYSConstast.SYS_USER_DEFAULT_PWD, salt , 2));
		userVo.setImgpath(SYSConstast.SYS_USER_DEFAULT_IMG);
		userVo.setType(SYSConstast.SYS_USER_TYPE_NORAML);
		
		ResultObj obj = null;
		try {
			userService.addUser(userVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		return obj;
	}

	//角色的修改
	@RequestMapping("loadUserByUserId")
	public User loadUserByUserId(UserVo userVo){
		return userService.queryUserByUserId(userVo);
	}
	
	@RequestMapping("updateUser")
	public ResultObj updateUser(UserVo userVo) {
		ResultObj obj = null;
		try {
			userService.updateUser(userVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		return obj;
	}
	
	//角色的删除
	@RequestMapping("deleteUser")
	public ResultObj deleteUser(UserVo userVo) {
		ResultObj obj = null;
		try {
			userService.deleteUserAndUserRole(userVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		return obj;
	}
	
	//重置密码
	@RequestMapping("resetUserPwd")
	public ResultObj resetUserPwd(UserVo userVo) {
		ResultObj obj = null;
		try {
			String salt =Md5Utils.createRandomStr();
			userVo.setSalt(salt);
			userVo.setPwd(Md5Utils.md5(SYSConstast.SYS_USER_DEFAULT_PWD, salt , 2));
			userService.updateUser(userVo);
			obj = new ResultObj(1, SYSConstast.SYS_USER_RESET_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_USER_RESET_ERROR);
		}
		return obj;
	}
	
	/**
	 * 角色分配
	 */
	@RequestMapping("selectUserRoleByUserId")
	public DataGridView selectUserRoleByUserId(UserVo userVo) {
		RoleVo roleVo = new RoleVo();
		roleVo.setAvailable(SYSConstast.SYS_ROLE_AVAILABLE_TRUE);
		List<Role> roles = roleService.queryAllRole(roleVo);
		List<Role> userRoles = roleService.queryUserRoleByUid(userVo);
		
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for (Role r1 : roles) {
			boolean checked = false;
			for (Role r2 : userRoles) {
				if(r2.getId()==r1.getId()) {
					checked = true;
					break;
				}
			}
			
			Map<String,Object> map = new HashMap<>();
			map.put("id", r1.getId());
			map.put("name", r1.getName());
			map.put("remark", r1.getRemark());
			map.put("LAY_CHECKED", checked);
			
			data.add(map);
		}
		
		return new DataGridView(0L,data);
	}
	
	@RequestMapping("saveUserRole")
	public ResultObj saveUserRole(UserVo userVo) {
		ResultObj obj = null;
		try {
			userService.saveUserRole(userVo);
			obj = new ResultObj(1, SYSConstast.SYS_OPTION_ROLE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			obj = new ResultObj(0, SYSConstast.SYS_OPTION_ROLE_ERROR);
		}
		return obj;
	}
	
}

