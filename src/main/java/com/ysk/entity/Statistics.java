package com.ysk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 统计实体类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Statistics {

    private Integer storeId;//仓库id

    private String storeName;//仓库名称

    private Integer totalInvent;//仓库商品库存数
}