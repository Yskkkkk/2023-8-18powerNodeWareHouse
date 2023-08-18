package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 权限表
 * @TableName auth_info
 */
@TableName(value ="auth_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Auth implements Serializable {
    /**
     * 
     */
    @TableId(value = "auth_id", type = IdType.AUTO)
    private Integer authId;

    /**
     * 父id为空或为0，表示一级权限
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 
     */
    @TableField(value = "auth_name")
    private String authName;

    /**
     * 
     */
    @TableField(value = "auth_desc")
    private String authDesc;

    /**
     * 
     */
    @TableField(value = "auth_grade")
    private Integer authGrade;

    /**
     * 1 模块 、2  列表、 3  按钮
     */
    @TableField(value = "auth_type")
    private String authType;

    /**
     * 
     */
    @TableField(value = "auth_url")
    private String authUrl;

    /**
     * 
     */
    @TableField(value = "auth_code")
    private String authCode;

    /**
     * 
     */
    @TableField(value = "auth_order")
    private Integer authOrder;

    /**
     * 1 启用 、0 禁用
     */
    @TableField(value = "auth_state")
    private String authState;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_by")
    private Integer updateBy;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //追加的List<Auth>集合属性 -- 用于存储当前权限(菜单)的子级权限(菜单)
    private List<Auth> childAuth;
}