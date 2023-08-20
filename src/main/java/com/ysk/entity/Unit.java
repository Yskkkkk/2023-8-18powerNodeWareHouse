package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 规格单位表
 * @TableName unit
 */
@TableName(value ="unit")
@Data
public class Unit implements Serializable {
    /**
     * 
     */
    @TableId(value = "unit_id", type = IdType.AUTO)
    private Integer unitId;

    /**
     * 
     */
    @TableField(value = "unit_name")
    private String unitName;

    /**
     * 
     */
    @TableField(value = "unit_desc")
    private String unitDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}