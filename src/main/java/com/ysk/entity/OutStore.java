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
 * 出库单
 * @TableName out_store
 */
@TableName(value ="out_store")
@Data
public class OutStore implements Serializable {
    /**
     * 
     */
    @TableId(value = "outs_id", type = IdType.AUTO)
    private Integer outsId;

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
    @TableField(value = "tally_id")
    private Integer tallyId;

    /**
     * 
     */
    @TableField(value = "out_price")
    private BigDecimal outPrice;

    /**
     * 
     */
    @TableField(value = "out_num")
    private Integer outNum;

    /**
     * 
     */
    @TableField(value = "create_by")
    private Integer createBy;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 0 否 1 是
     */
    @TableField(value = "is_out")
    private String isOut;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //------------------追加的属性-------------------------

    private String productName;//商品名称

    private String startTime;//起始时间

    private String endTime;//结束时间

    private String storeName;//仓库名称

    private String userCode;//创建出库单的用户的名称
}