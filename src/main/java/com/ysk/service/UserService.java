package com.ysk.service;

import com.ysk.entity.Result;
import com.ysk.page.Page;
import com.ysk.entity.User;

public interface UserService  {
    //根据账号查询用户的业务方法
    public User queryUserByCode(String userCode);

    //分页查询用户的业务方法
    public Page queryUserByPage(Page page, User user);

    //添加用户
    public Result saveUser(User user);

    //启用或禁用用户的业务方法
    public Result setUserState(User user);
}
