package com.gxz.sys.mapper;

import java.util.List;

import com.gxz.sys.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    //查询所有的权限或菜单
    List<Permission> queryAllPermission(Permission permission);
    
    //删除---查询有没有子节点
    Integer queryPermissionChildren(Integer id);
    
    /**
     * 角色分配   根据角色ID查询权限
     */
    List<Permission> queryPermissionByRoleId(Integer roleid);
    
	List<Permission> queryPermissionByUserId(String sysTypePermission, Integer uid);
}