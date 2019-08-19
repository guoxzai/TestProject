package com.gxz.sys.mapper;

import java.util.List;

import com.gxz.sys.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User queryUserByLoginname(String loginname);
    
    List<User> queryAllUser(User user);
    /**
     * 角色删除
     * @param id
     * @return
     */
	Integer userRoleIsExist(Integer id);

	void deleteUserRole(Integer id);

	//分配角色
	void saveUserRole(Integer id, Integer rid);
	
	
}