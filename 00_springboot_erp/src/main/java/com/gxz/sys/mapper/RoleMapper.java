package com.gxz.sys.mapper;

import java.util.List;

import com.gxz.sys.domain.Role;
import com.gxz.sys.vo.RoleVo;
import com.gxz.sys.vo.UserVo;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryAllRole(RoleVo roleVo);
    
    /**
     * 角色分配   先删除在分配
     */
    Integer rolePermissionIsExistRid(Integer rid);
    
    void deleteRolePermission(Integer rid);
    
    void saveRolePermission(Integer rid,Integer id);
    
    //用户分配角色
	List<Role> queryUserRoleByUid(Integer uid);
}