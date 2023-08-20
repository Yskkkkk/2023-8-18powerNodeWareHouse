package com.ysk.mapper;

import com.ysk.entity.Role;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2023-08-19 19:26:51
* @Entity com.ysk.entity.Role
*/
@Mapper
public interface RoleMapper {

    //查询所有角色
    public List<Role> findAllRole();

    //根据用户id查询用户分配的所有角色
    public List<Role> findUserRoleByUid(Integer userId);

    //根据角色名查询角色id的方法
    public Integer findRoleIdByName(String roleName);

    //查询角色行数的方法
    public Integer findRoleRowCount(Role role);

    //分页查询角色的方法
    public List<Role> findRolePage(@Param("page") Page page, @Param("role")Role role);


    //根据角色名称或者角色代码查询角色的方法
    public Role findRoleByNameOrCode(String roleName, String roleCode);

    //添加角色的方法
    public int insertRole(Role role);

    //根据角色id修改角色状态的方法
    public int updateRoleState(Role role);

    //根据角色id删除角色的方法
    public int deleteRoleById(Integer roleId);

    //根据角色id修改角色描述的方法
    public int updateDescById(Role role);
}




