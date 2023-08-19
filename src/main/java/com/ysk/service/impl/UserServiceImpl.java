package com.ysk.service.impl;

import com.ysk.dto.AssignRoleDto;
import com.ysk.entity.Result;
import com.ysk.entity.User;
import com.ysk.entity.UserRole;
import com.ysk.mapper.RoleMapper;
import com.ysk.mapper.UserMapper;
import com.ysk.mapper.UserRoleMapper;
import com.ysk.page.Page;
import com.ysk.service.UserService;
import com.ysk.utils.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page queryUserByPage(Page page, User user) {

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
        if (u != null) {//账号存在
            return Result.err(Result.CODE_ERR_BUSINESS, "账号已存在");
        }

        //对密码做加密
        String password = DigestUtil.hmacSign(user.getUserPwd());
        user.setUserPwd(password);

        //执行添加
        int i = usermapper.insertUser(user);
        if (i > 0) {
            return Result.ok("用户添加成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "用户添加失败");
    }

    @Override
    public Result setUserState(User user) {
        int i = usermapper.setUserStateByID(user.getUserId(), user.getUserState());
        if (i > 0) {
            return Result.ok("启用或禁用用户成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "启用或禁用用户失败");
    }

    //给用户分配角色的业务方法
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Transactional //事物处理
    @Override
    public void assignRole(AssignRoleDto assignRoleDto) {

        userRoleMapper.removeUserRoleByUid(assignRoleDto.getUserId());

        List<String> roleCheckList = assignRoleDto.getRoleCheckList();
        for (String roleName : roleCheckList) {
            Integer roleId = roleMapper.findRoleIdByName(roleName);
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(assignRoleDto.getUserId());
            userRoleMapper.insertUserRole(userRole);

        }
    }

    @Override
    public Result deleteUserByIds(List<Integer> userIdList) {

        int i = usermapper.setIdsDeleteByUids(userIdList);
        if(i > 0){
            return Result.ok("用户删除成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"用户删除失败");
    }

    @Override
    public Result setUserById(User user) {

        int i = usermapper.setUserNameByUid(user);
        if(i > 0){
            return Result.ok("用户修改成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"用户修改失败");
    }

    @Override
    public Result setPasswordByUid(Integer userId) {
        //给定初始密码123456并加密
        String password = DigestUtil.hmacSign("123456");
        int i = usermapper.setPwdByUid(userId, password);
        if(i > 0){
            return Result.ok("密码重置成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"密码重置失败");
    }
}
