package com.ysk.controller;

import com.ysk.entity.Auth;
import com.ysk.entity.Result;
import com.ysk.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    //查询所有权限菜单树的url接口/auth/auth-tree
    @RequestMapping("/auth-tree")
    public Result loadAllAuthTree(){

        List<Auth> allAuthTree = authService.getAllAuthTree();
        return Result.ok(allAuthTree);
    }
}
