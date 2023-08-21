package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

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
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 0 否 1 是
     */
    @TableField(value = "is_out")
    private String isOut;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}