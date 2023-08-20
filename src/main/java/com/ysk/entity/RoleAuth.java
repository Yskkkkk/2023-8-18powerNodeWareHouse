package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限表
 * @TableName role_auth
 */
@TableName(value ="role_auth")
@Data
public class RoleAuth implements Serializable {
    /**
     * 
     */
    @TableId(value = "role_auth_id", type = IdType.AUTO)
    private Integer roleAuthId;

    /**
     * 
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 
     */
    @TableField(value = "auth_id")
    private Integer authId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}