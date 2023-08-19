package com.ysk.service.impl;

import com.ysk.entity.Role;
import com.ysk.mapper.RoleMapper;
import com.ysk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2023-08-19 19:26:51
*/
//2）指定缓存的名称(数据保存到redis中键的前缀)，一般值给标注@CacheConfig注解的类的全路径
@CacheConfig(cacheNames = "com.ysk.service.impl.RoleServiceImpl")
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    //查询所有角色的业务
    @Cacheable(key = "'all:role'")
    @Override
    public List<Role> queryAllRole() {
        return roleMapper.findAllRole();
    }


    //根据用户id查询用户分配的所有角色
    @Override
    public List<Role> queryUserRoleByUid(Integer userId) {
        return roleMapper.findUserRoleByUid(userId);
    }
}




