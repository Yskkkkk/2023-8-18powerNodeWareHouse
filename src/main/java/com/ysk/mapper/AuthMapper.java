package com.ysk.mapper;

import com.ysk.entity.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【auth_info(权限表)】的数据库操作Mapper
* @createDate 2023-08-17 17:11:30
* @Entity com.ysk.entity.Auth
*/
@Mapper
public interface AuthMapper  {

    //根据userId查询用户权限下的所有菜单的方法
   public List<Auth> findAuthByUid(Integer userId);
}




