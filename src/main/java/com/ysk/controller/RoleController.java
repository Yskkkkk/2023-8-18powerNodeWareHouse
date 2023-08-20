package com.ysk.controller;

import com.ysk.dto.AssignAuthDto;
import com.ysk.entity.CurrentUser;
import com.ysk.entity.Result;
import com.ysk.entity.Role;
import com.ysk.entity.WarehouseConstants;
import com.ysk.page.Page;
import com.ysk.service.RoleService;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private TokenUtils tokenUtils;
    //查询所有角色
    @RequestMapping("/role-list")
    public Result roleList(){
        List<Role> roleList = roleService.queryAllRole();

        return Result.ok(roleList);
    }

    //分页查询角色的url接口/role/role-page-lis
    @RequestMapping("/role-page-list")
    public Result roleListPage(Page page, Role role){
        page = roleService.quertRolePage(page, role);

        return Result.ok(page);
    }

    //添加角色/role/role-add
    @RequestMapping("/role-add")
    public Result addRole(@RequestBody Role role,
                          @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int createBy = currentUser.getUserId();
        role.setCreateBy(createBy);
        Result result = roleService.saveRole(role);
        return result;
    }

    //启用和禁用角色状态/role/role-state-update
    @RequestMapping("/role-state-update")
    public Result updateRole(@RequestBody Role role,
                             @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);

        //获取当前登录的用户id,即修改角色的用户id
        int updateBy = currentUser.getUserId();

        role.setUpdateBy(updateBy);
        role.setUpdateTime(new Date());

        //执行业务
        Result result = roleService.updateRoleState(role);
        return result;
    }

    //查询角色分配的所有权限菜单的url接口/role/role-auth
    @RequestMapping("/role-auth")
    public Result roleAuth(Integer roleId){

        List<Integer> auths = roleService.queryRoleAuthIds(roleId);
        return Result.ok(auths);
    }

    //给角色分配菜单权限的url接口/role/auth-grant
    @RequestMapping("/auth-grant")
    public Result grantAuth(@RequestBody AssignAuthDto assignAuthDto){
            roleService.saveRoleAuth(assignAuthDto);

            return Result.ok("权限分配成功");
    }

    //删除角色 url接口 /role/role-delete/{roleId}
    @RequestMapping("/role-delete/{roleId}")
    public Result deleteRole(@PathVariable Integer roleId){
        //执行业务
        roleService.deleteRole(roleId);
        //响应
        return Result.ok("角色删除成功！");
    }

    //修改角色 url接口 /role/role-update
    @RequestMapping("/role-update")
    public Result updateRoleDesc(@RequestBody Role role,
                             @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int updateBy = currentUser.getUserId();
        role.setUpdateBy(updateBy);
        Result result = roleService.updateRoleDesc(role);
        return result;
    }
}
