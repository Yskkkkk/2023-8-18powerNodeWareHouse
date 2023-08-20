package com.ysk.mapper;

import com.ysk.entity.RoleAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【role_auth(角色权限表)】的数据库操作Mapper
* @createDate 2023-08-20 10:58:03
* @Entity com.ysk.entity.RoleAuth
*/
@Mapper
public interface RoleAuthMapper  {

    //根据角色id查询分配的所有权限菜单的方法
    public List<Integer> findAuthIdsByRid(Integer roleId);

    //根据角色id删除角色权限关系
    public int removeRoleAuthByRid(Integer roleId);

    //添加角色权限关系
    public int insertRoleAuth(RoleAuth roleAuth);


}




