package com.ysk.mapper;

import com.ysk.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【user_role(用户角色表)】的数据库操作Mapper
* @createDate 2023-08-19 19:55:09
* @Entity com.ysk.entity.UserRole
*/
@Mapper
public interface UserRoleMapper  {
    //根据用户id删除用户已分配的用户角色关系
    public int removeUserRoleByUid(Integer userId);

    //添加用户角色关系
    public int insertUserRole(UserRole userRole);
}




