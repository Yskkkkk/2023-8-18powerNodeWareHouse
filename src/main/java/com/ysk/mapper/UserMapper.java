package com.ysk.mapper;

import com.ysk.page.Page;
import com.ysk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    user_info表的mapper接口
*/
@Mapper
public interface UserMapper {
    //根据账号查询用户信息
    public User findUserByCode(String userCode);

    //查询用户行数的方法
    public Integer findUserRowCount(User user);
    //分页查询用户的方法
    public List<User> findUserByPage(@Param("page") Page page, @Param("user")User user);

    //添加用户
    public int insertUser(User user);

    //根据用户id修改用户状态
    public int setUserStateByID(Integer userId,String userState);
}
