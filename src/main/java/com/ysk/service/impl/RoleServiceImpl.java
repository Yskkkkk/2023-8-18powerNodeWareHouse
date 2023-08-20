package com.ysk.service.impl;

import com.ysk.dto.AssignAuthDto;
import com.ysk.entity.Result;
import com.ysk.entity.Role;
import com.ysk.entity.RoleAuth;
import com.ysk.mapper.AuthMapper;
import com.ysk.mapper.RoleAuthMapper;
import com.ysk.mapper.RoleMapper;
import com.ysk.page.Page;
import com.ysk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private RoleAuthMapper roleAuthMapper;
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

    @Override
    public Page quertRolePage(Page page, Role role) {

        //查询角色行数
        Integer roleRowCount = roleMapper.findRoleRowCount(role);

        //分页查询角色
        List<Role> roleList = roleMapper.findRolePage(page, role);

        //组装分页信息
        page.setTotalNum(roleRowCount);
        page.setResultList(roleList);

        return page;
    }

    //添加用户
    @Override
    public Result saveRole(Role role) {
        Role oldRole = roleMapper.findRoleByNameOrCode(role.getRoleName(), role.getRoleCode());
        if(oldRole != null){
            return Result.err(Result.CODE_ERR_BUSINESS,"用户已存在");
        }
        roleMapper.insertRole(role);
        return Result.ok("用户添加成功");
    }

    //启用或禁用角色状态
    @Override
    public Result updateRoleState(Role role) {
        int i = roleMapper.updateRoleState(role);
        if(i>0){
            return Result.ok("修改成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "修改失败！");
    }

    //根据角色id查询角色分配的所有权限菜单的业务
    @Override
    public List<Integer> queryRoleAuthIds(Integer roleId) {
        List<Integer> authByRid = roleAuthMapper.findAuthIdsByRid(roleId);
        return authByRid;
    }

    //给角色分配权限
    @Transactional //事物处理
    @Override
    public void saveRoleAuth(AssignAuthDto assignAuthDto) {

        //删除角色之前分配的所有权限
        roleAuthMapper.removeRoleAuthByRid(assignAuthDto.getRoleId());

        //添加角色权限关系
        List<Integer> authIdList = assignAuthDto.getAuthIds();

        for(Integer authId : authIdList){
            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setRoleId(assignAuthDto.getRoleId());
            roleAuth.setAuthId(authId);
            roleAuthMapper.insertRoleAuth(roleAuth);
        }
    }


    //删除角色的业务方法
    public void deleteRole(Integer roleId){
        int i = roleMapper.deleteRoleById(roleId);
        if(i>0){
            //根据角色id删除给角色已分配的所有权限(菜单)
            roleAuthMapper.removeRoleAuthByRid(roleId);
        }
    }

    //修改角色描述的业务方法
    @Override
    public Result updateRoleDesc(Role role) {

        int i = roleMapper.updateDescById(role);
        if(i > 0){
            return Result.ok("角色修改成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "角色修改失败！");
    }

}




