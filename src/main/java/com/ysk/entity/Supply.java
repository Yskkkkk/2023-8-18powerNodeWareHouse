package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 供货商
 * @TableName supply
 */
@TableName(value ="supply")
@Data
public class Supply implements Serializable {
    /**
     * 
     */
    @TableId(value = "supply_id", type = IdType.AUTO)
    private Integer supplyId;

    /**
     * 
     */
    @TableField(value = "supply_num")
    private String supplyNum;

    /**
     * 
     */
    @TableField(value = "supply_name")
    private String supplyName;

    /**
     * 
     */
    @TableField(value = "supply_introduce")
    private String supplyIntroduce;

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

    /**
     * 
     */
    @TableField(value = "address")
    private String address;

    /**
     * 0:可用  1:不可用
     */
    @TableField(value = "is_delete")
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}