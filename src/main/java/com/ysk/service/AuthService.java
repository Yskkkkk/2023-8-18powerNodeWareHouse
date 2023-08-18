package com.ysk.service;

import com.ysk.entity.Auth;

import java.util.List;

/**
* @author admin
* @description 针对表【auth_info(权限表)】的数据库操作Service
* @createDate 2023-08-17 17:11:30
*/
public interface AuthService {
   public List<Auth> authTreeByUid(Integer userId);
}
