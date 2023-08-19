package com.ysk.service;

import com.ysk.dto.AssignRoleDto;
import com.ysk.entity.Result;
import com.ysk.entity.User;
import com.ysk.page.Page;

import java.util.List;

public interface UserService  {
    //根据账号查询用户的业务方法
    public User queryUserByCode(String userCode);

    //分页查询用户的业务方法
    public Page queryUserByPage(Page page, User user);

    //添加用户
    public Result saveUser(User user);

    //启用或禁用用户的业务方法
    public Result setUserState(User user);

    //给用户分配角色的业务方法
    public void assignRole(AssignRoleDto assignRoleDto);

    //删除用户的业务方法
    public Result deleteUserByIds(List<Integer> userIdList);

    //修改用户信息
    public Result setUserById(User user);

    //根据用户id修改用户密码的业务
    public Result setPasswordByUid(Integer userId);
}
