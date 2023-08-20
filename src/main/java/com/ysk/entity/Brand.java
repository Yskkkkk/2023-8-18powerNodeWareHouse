package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 品牌
 * @TableName brand
 */
@TableName(value ="brand")
@Data
public class Brand implements Serializable {
    /**
     * 
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Integer brandId;

    /**
     * 
     */
    @TableField(value = "brand_name")
    private String brandName;

    /**
     * 
     */
    @TableField(value = "brand_leter")
    private String brandLeter;

    /**
     * 
     */
    @TableField(value = "brand_desc")
    private String brandDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}