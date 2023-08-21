package com.ysk.mapper;

import com.ysk.entity.BuyList;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【buy_list(采购单)】的数据库操作Mapper
* @createDate 2023-08-21 17:06:13
* @Entity com.ysk.entity.BuyList
*/
@Mapper
public interface BuyListMapper  {

    //添加采购单的方法
    public int insertPurchase(BuyList buyList);

}




