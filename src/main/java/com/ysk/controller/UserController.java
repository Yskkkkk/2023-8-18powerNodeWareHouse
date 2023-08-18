package com.ysk.controller;

import com.ysk.entity.CurrentUser;
import com.ysk.entity.Result;
import com.ysk.entity.User;
import com.ysk.entity.WarehouseConstants;
import com.ysk.page.Page;
import com.ysk.service.UserService;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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

}
