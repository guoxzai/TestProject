package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.Role;
import com.gxz.sys.mapper.RoleMapper;
import com.gxz.sys.service.RoleService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.RoleVo;
import com.gxz.sys.vo.UserVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private  RoleMapper roleMapper;

	@Override
	public DataGridView queryAllRightDataGrid(RoleVo roleVo) {
		Page<Object> page = PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
		List<Role> data = roleMapper.queryAllRole(roleVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addRole(RoleVo roleVo) {
		roleMapper.insertSelective(roleVo);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		roleMapper.updateByPrimaryKeySelective(roleVo);
	}

	@Override
	public void deleteRole(RoleVo roleVo) {
		Integer isExistRid = roleMapper.rolePermissionIsExistRid(roleVo.getId());
		if(isExistRid>0) {
			roleMapper.deleteRolePermission(roleVo.getId());
		}
		roleMapper.deleteByPrimaryKey(roleVo.getId());
	}

	@Override
	public void saveRolePermission(RoleVo roleVo) {
		Integer isExistRid = roleMapper.rolePermissionIsExistRid(roleVo.getId());
		if(isExistRid>0) {
			roleMapper.deleteRolePermission(roleVo.getId());
		}
		
		Integer[] ids = roleVo.getIds();
		if(null != ids && ids.length>0) {
			for (Integer id : ids) {
				roleMapper.saveRolePermission(roleVo.getId(), id);
			}
		}
		
	}

	/**
	 * 用户角色分配
	 */
	@Override
	public List<Role> queryAllRole(RoleVo roleVo) {
		return roleMapper.queryAllRole(roleVo);
	}

	@Override
	public List<Role> queryUserRoleByUid(UserVo userVo) {
		return roleMapper.queryUserRoleByUid(userVo.getId());
	}
	
}
