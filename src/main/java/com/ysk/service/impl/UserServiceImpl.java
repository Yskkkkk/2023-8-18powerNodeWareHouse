package com.ysk.service.impl;

import com.ysk.entity.Result;
import com.ysk.entity.User;
import com.ysk.mapper.UserMapper;
import com.ysk.page.Page;
import com.ysk.service.UserService;
import com.ysk.utils.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public User queryUserByCode(String userCode) {
        return usermapper.findUserByCode(userCode);
    }

    @Override
    public Page queryUserByPage(Page page, User user){

        //查询用户行数
        Integer count = usermapper.findUserRowCount(user);
        
        //分页查询用户
        List<User> userList = usermapper.findUserByPage(page, user);

        //组装所有分页信息
        page.setTotalNum(count);
        page.setResultList(userList);
        return page;
    }

    @Override
    public Result saveUser(User user) {
        //判断账号是否存在
        User u = usermapper.findUserByCode(user.getUserCode());
        if(u != null){//账号存在
            return Result.err(Result.CODE_ERR_BUSINESS,"账号已存在");
        }

        //对密码做加密
        String password = DigestUtil.hmacSign(user.getUserPwd());
        user.setUserPwd(password);

        //执行添加
        int i = usermapper.insertUser(user);
        if(i > 0){
            return Result.ok("用户添加成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"用户添加失败");
    }

    @Override
    public Result setUserState(User user) {
        int i = usermapper.setUserStateByID(user.getUserId(),user.getUserState());
        if(i > 0){
            return Result.ok("启用或禁用用户成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"启用或禁用用户失败");
    }
}
