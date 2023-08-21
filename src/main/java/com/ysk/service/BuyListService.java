package com.ysk.service;

import com.ysk.entity.BuyList;
import com.ysk.entity.Result;

/**
* @author admin
* @description 针对表【buy_list(采购单)】的数据库操作Service
* @createDate 2023-08-21 17:06:13
*/
public interface BuyListService  {
    //添加采购单的业务方法
    public Result savePurchase(BuyList purchase);
}
