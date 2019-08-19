package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.User;
import com.gxz.sys.mapper.UserMapper;
import com.gxz.sys.service.UserService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserByLoginname(String loginname) {
		return userMapper.queryUserByLoginname(loginname);
	}

	@Override
	public DataGridView queryAllRightDataGrid(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(),userVo.getLimit());
		List<User> data = userMapper.queryAllUser(userVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public List<User> loadAllUserForList(UserVo userVo) {
		return userMapper.queryAllUser(userVo);
	}

	@Override
	public void addUser(UserVo userVo) {
		userMapper.insertSelective(userVo);
	}

	@Override
	public User queryUserByUserId(UserVo userVo) {
		return userMapper.selectByPrimaryKey(userVo.getId());
	}

	@Override
	public void updateUser(UserVo userVo) {
		userMapper.updateByPrimaryKeySelective(userVo);
	}

	@Override
	public void deleteUserAndUserRole(UserVo userVo) {
		Integer isExist = userMapper.userRoleIsExist(userVo.getId());
		if(isExist>0) {
			userMapper.deleteUserRole(userVo.getId());
		}
		userMapper.deleteByPrimaryKey(userVo.getId());
	}
	
	@Override
	public void saveUserRole(UserVo userVo) {
		Integer isExist = userMapper.userRoleIsExist(userVo.getId());
		if(isExist>0) {
			userMapper.deleteUserRole(userVo.getId());
		}
		Integer[] rids = userVo.getIds();
		if(null!=rids && rids.length>0) {
			for (Integer rid : rids) {
				userMapper.saveUserRole(userVo.getId(),rid);
			}
		}
	}

}
