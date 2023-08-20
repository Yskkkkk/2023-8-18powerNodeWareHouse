package com.ysk.service;

import com.ysk.dto.AssignAuthDto;
import com.ysk.entity.Result;
import com.ysk.entity.Role;
import com.ysk.page.Page;

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

    //分页查询角色的业务方法
    public Page quertRolePage(Page page, Role role);

    //添加用户角色的业务方法
    public Result saveRole(Role role);

    //修改角色状态的方法
    public Result updateRoleState(Role role);

    //查询角色分配的所有权限菜单的业务
    public List<Integer> queryRoleAuthIds(Integer roleId);

    //给角色分配权限
    public void saveRoleAuth(AssignAuthDto assignAuthDto);

    //删除角色的业务方法
    public void deleteRole(Integer roleId);

    //修改角色描述的业务方法
    public Result updateRoleDesc(Role role);
}
