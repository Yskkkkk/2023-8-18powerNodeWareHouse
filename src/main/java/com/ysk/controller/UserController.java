package com.ysk.controller;

import com.ysk.dto.AssignRoleDto;
import com.ysk.entity.*;
import com.ysk.page.Page;
import com.ysk.service.RoleService;
import com.ysk.service.UserService;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //分页查询用户的接口/user/user-list
    @RequestMapping("/user-list")
    public Result userList(Page page, User user){
         page = userService.queryUserByPage(page, user);
        return Result.ok(page);
    }

    @Autowired
    private TokenUtils tokenUtils;
    //添加用户的接口/user/addUser
    @RequestMapping("/addUser")
    public Result addUser(@RequestBody User user,@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        //拿到当前登录用户id
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int createBy = currentUser.getUserId();
        user.setCreateBy(createBy);

        //执行业务
        Result result = userService.saveUser(user);
        return  result;
    }

    /*
    修改用户状态
    启用或禁用接口/user/updateState
     */
    @RequestMapping("/updateState")
    public Result updateUserState(@RequestBody User user){
        //执行业务
        Result result = userService.setUserState(user);

        return result;
    }

    /*
    查询用户已分配的角色得的url接口/user/user-role-list/{userId}

    @PathVariable Integer userId -- 表示将userId的值赋值给请求处理入参变量userId
    */
    @RequestMapping("/user-role-list/{userId}")
    public Result userRoleList(@PathVariable Integer userId){
        List<Role> roleList = roleService.queryUserRoleByUid(userId);
        return Result.ok(roleList);
    }

    //给用户分配角色的url接口/user/assignRole
    @RequestMapping("/assignRole")
    public Result assignRole(@RequestBody AssignRoleDto assignRoleDto){
        userService.assignRole(assignRoleDto);

        return Result.ok("分配成功");
    }

    //根据用户ids批量删除用户/user/deleteUserList
    @RequestMapping("/deleteUserList")
    public Result deleteUserByIds(@RequestBody List<Integer> userIdList){

        Result result = userService.deleteUserByIds(userIdList);
        return result;
    }

    //根据用户id删除单个用户url接口/user/deleteUser/{userId}
    @RequestMapping("/deleteUser/{userId}")
    public Result deleteUserById(@PathVariable Integer userId){

        Result result = userService.deleteUserByIds(Arrays.asList(userId));
        return result;
    }

    //修改用户 url 接口/user/updateUser
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody User user,
                             @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int updateBy = currentUser.getUserId();

        user.setUpdateBy(updateBy);

        Result result = userService.setUserById(user);
        return result;
    }

    //重置密码/user/updatePwd/{userId}
    @RequestMapping("/updatePwd/{userId}")
    public Result updatePwd(@PathVariable Integer userId){
        Result result = userService.setPasswordByUid(userId);
        return result;
    }
}
