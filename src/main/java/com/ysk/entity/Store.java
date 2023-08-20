package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 仓库表
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 
     */
    @TableId(value = "store_id", type = IdType.AUTO)
    private Integer storeId;

    /**
     * 
     */
    @TableField(value = "store_name")
    private String storeName;

    /**
     * 
     */
    @TableField(value = "store_num")
    private String storeNum;

    /**
     * 
     */
    @TableField(value = "store_address")
    private String storeAddress;

    /**
     * 
     */
    @TableField(value = "concat")
    private String concat;

    /**
     * 
     */
    @TableField(value = "phone")
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}