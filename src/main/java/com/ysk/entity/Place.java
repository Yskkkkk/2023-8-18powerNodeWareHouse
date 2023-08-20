package com.ysk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 产地
 * @TableName place
 */
@TableName(value ="place")
@Data
public class Place implements Serializable {
    /**
     * 
     */
    @TableId(value = "place_id", type = IdType.AUTO)
    private Integer placeId;

    /**
     * 
     */
    @TableField(value = "place_name")
    private String placeName;

    /**
     * 
     */
    @TableField(value = "place_num")
    private String placeNum;

    /**
     * 
     */
    @TableField(value = "introduce")
    private String introduce;

    /**
     * 0:可用  1:不可用
     */
    @TableField(value = "is_delete")
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}