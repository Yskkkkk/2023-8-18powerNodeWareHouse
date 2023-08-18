package com.ysk.mapper;

import com.ysk.entity.User;
import org.apache.ibatis.annotations.Mapper;

/*
    user_info表的mapper接口
*/
@Mapper
public interface UserMapper {
    public User findUserByCode(String userCode);
}
