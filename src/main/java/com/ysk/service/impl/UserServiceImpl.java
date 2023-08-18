package com.ysk.service.impl;

import com.ysk.entity.User;
import com.ysk.mapper.UserMapper;
import com.ysk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public User queryUserByCode(String userCode) {
        return usermapper.findUserByCode(userCode);
    }
}
