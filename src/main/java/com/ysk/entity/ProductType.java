package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品分类表
 * @TableName product_type
 */
@TableName(value ="product_type")
@Data
public class ProductType implements Serializable {
    /**
     * 
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 
     */
    @TableField(value = "type_code")
    private String typeCode;

    /**
     * 
     */
    @TableField(value = "type_name")
    private String typeName;

    /**
     * 
     */
    @TableField(value = "type_desc")
    private String typeDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}