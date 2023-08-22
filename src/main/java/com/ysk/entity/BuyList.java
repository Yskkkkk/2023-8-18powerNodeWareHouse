package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购单
 * @TableName buy_list
 */
@TableName(value ="buy_list")
@Data
public class BuyList implements Serializable {
    /**
     * 
     */
    @TableId(value = "buy_id", type = IdType.AUTO)
    private Integer buyId;

    /**
     * 
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 
     */
    @TableField(value = "store_id")
    private Integer storeId;

    /**
     * 
     */
    @TableField(value = "buy_num")
    private Integer buyNum;

    /**
     * 
     */
    @TableField(value = "fact_buy_num")
    private Integer factBuyNum;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "buy_time")
    private Date buyTime;

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
    @TableField(value = "buy_user")
    private String buyUser;

    /**
     * 
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 0 否 1 是
     */
    @TableField(value = "is_in")
    private String isIn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //---------------追加属性---------------------------

    private String productName;//商品名称

    private String storeName;//仓库名称

    private String startTime;//搜索起始时间

    private String endTime;//搜索结束时间
}