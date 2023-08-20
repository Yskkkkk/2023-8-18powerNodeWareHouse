package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    /**
     * 
     */
    @TableField(value = "store_id")
    private Integer storeId;

    /**
     * 
     */
    @TableField(value = "brand_id")
    private Integer brandId;

    /**
     * 
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 
     */
    @TableField(value = "product_num")
    private String productNum;

    /**
     * 
     */
    @TableField(value = "product_invent")
    private Integer productInvent;

    /**
     * 
     */
    @TableField(value = "type_id")
    private Integer typeId;

    /**
     * 
     */
    @TableField(value = "supply_id")
    private Integer supplyId;

    /**
     * 
     */
    @TableField(value = "place_id")
    private Integer placeId;

    /**
     * 
     */
    @TableField(value = "unit_id")
    private Integer unitId;

    /**
     * 
     */
    @TableField(value = "introduce")
    private String introduce;

    /**
     * 0 下架 1 上架
     */
    @TableField(value = "up_down_state")
    private String upDownState;

    /**
     * 
     */
    @TableField(value = "in_price")
    private BigDecimal inPrice;

    /**
     * 
     */
    @TableField(value = "sale_price")
    private BigDecimal salePrice;

    /**
     * 
     */
    @TableField(value = "mem_price")
    private BigDecimal memPrice;

    /**
     * 
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 
     */
    @TableField(value = "create_by")
    private Integer createBy;

    /**
     * 
     */
    @TableField(value = "update_by")
    private Integer updateBy;

    /**
     * 
     */
    @TableField(value = "imgs")
    private String imgs;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "product_date")
    private Date productDate;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "supp_date")
    private Date suppDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //追加属性


    //品牌名称brandName、商品分类名称typeName、
    //供应商名称supplyName、产地名placeName、过期与否isOverDate
    private String brandName;//品牌名称

    private String supplyName;//供应商名称

    private String placeName;//产地名

    private String typeName;//商品分类名称

    private Integer isOverDate;//过期与否

    private String storeName;//仓库名称

    private String unitName;//单位名称
}