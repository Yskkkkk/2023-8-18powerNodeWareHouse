package com.ysk.service;

import com.ysk.entity.Role;

import java.util.List;

/**
* @author admin
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2023-08-19 19:26:51
*/
public interface RoleService  {

    //查询所有角色的业务
    public List<Role> queryAllRole();

    ////根据用户id查询用户分配的所有角色
    public List<Role> queryUserRoleByUid(Integer userId);
}
