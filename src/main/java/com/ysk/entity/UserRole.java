package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户角色表
 * @TableName user_role
 */
@TableName(value ="user_role")
@Data
public class UserRole implements Serializable {
    /**
     * 
     */
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    /**
     * 
     */
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}