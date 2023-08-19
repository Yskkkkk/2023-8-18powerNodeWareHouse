package com.ysk.mapper;

import com.ysk.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2023-08-19 19:26:51
* @Entity com.ysk.entity.Role
*/
@Mapper
public interface RoleMapper  {

    //查询所有角色
    public List<Role> findAllRole();

    //根据用户id查询用户分配的所有角色
    public List<Role> findUserRoleByUid(Integer userId);

    //根据角色名查询角色id的方法
    public Integer findRoleIdByName(String roleName);
}




