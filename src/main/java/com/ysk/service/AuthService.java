package com.ysk.service;

import com.ysk.entity.Auth;

import java.util.List;

/**
* @author admin
* @description 针对表【auth_info(权限表)】的数据库操作Service
* @createDate 2023-08-17 17:11:30
*/
public interface AuthService {

   //根据用户角色id查询用户权限下的所有菜单的方法
   public List<Auth> authTreeByUid(Integer userId);

   //查询整个权限(菜单)树的业务方法
   public List<Auth> getAllAuthTree();
}
