package com.ysk.service.impl;

import com.alibaba.fastjson.JSON;
import com.ysk.entity.Auth;
import com.ysk.mapper.AuthMapper;
import com.ysk.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @author admin
* @description 针对表【auth_info(权限表)】的数据库操作Service实现
* @createDate 2023-08-17 17:11:30
*/
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;
    /*
        查询用户菜单树的业务方法

        向redis缓存 -- 键authTree:userId 值菜单树List<Auth>转json串
     */
    @Override
    public List<Auth> authTreeByUid(Integer userId) {

        //先从redis中查询缓存的用户菜单树
        String authTreeJson = redisTemplate.opsForValue().get("authTree:" + userId);

        if(StringUtils.hasText(authTreeJson)){//说明redis中有用户菜单树缓存
            //将菜单树List<Auth>转的json串转回菜单树List<Auth>并返回
            List<Auth> authTreeList = JSON.parseArray(authTreeJson, Auth.class);
            return authTreeList;
        }
            //说明redis中没有用户菜单树缓存
            //查询用户权限下的所有菜单
            List<Auth> allAuthList = authMapper.findAuthByUid(userId);
            //将所有菜单List<Auth>转成菜单树List<Auth>
            List<Auth> authTreeList = allAuthToAuthTree(allAuthList, 0);

            //向redis中缓存
            redisTemplate.opsForValue().set("authTree:" + userId,JSON.toJSONString(authTreeList));
            return authTreeList;
    }

    //将所有权限(菜单)转成权限(菜单)树的递归算法
    private List<Auth> allAuthToAuthTree(List<Auth> allAuthList,Integer pid){

        //获取父权限(菜单)id为参数parentId的所有权限(菜单)
        //【parentId最初为0,即最初查的是所有一级权限(菜单)】
        List<Auth> firstLevelAuthList = new ArrayList<>();
        for(Auth auth: allAuthList){
            if(auth.getParentId().equals(pid)){
                firstLevelAuthList.add(auth);
            }
        }
        //查询List<Auth> authList中每个权限(菜单)的所有子级权限(菜单)
        for(Auth firstAuth : firstLevelAuthList){
            List<Auth> secondLevelAuthList = allAuthToAuthTree(allAuthList, firstAuth.getAuthId());
            firstAuth.setChildAuth(secondLevelAuthList);
        }

        return firstLevelAuthList;
    }
}
