package com.ysk.controller;

import com.ysk.entity.Result;
import com.ysk.entity.Role;
import com.ysk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查询所有角色
    @RequestMapping("/role-list")
    public Result roleList(){
        List<Role> roleList = roleService.queryAllRole();

        return Result.ok(roleList);
    }
}
