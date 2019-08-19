package com.gxz.sys.service;

import java.util.List;

import com.gxz.sys.domain.User;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.UserVo;

public interface UserService {

	public User queryUserByLoginname(String loginname);

	/**********************用户管理***********************/
	public DataGridView queryAllRightDataGrid(UserVo userVo);

	public List<User> loadAllUserForList(UserVo userVo);

	public void addUser(UserVo userVo);

	public User queryUserByUserId(UserVo userVo);

	public void updateUser(UserVo userVo);

	public void deleteUserAndUserRole(UserVo userVo);
	
	//分配角色
	public void saveUserRole(UserVo userVo);
	
}
