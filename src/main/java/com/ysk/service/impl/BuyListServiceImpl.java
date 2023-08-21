package com.ysk.service.impl;

import com.ysk.entity.BuyList;
import com.ysk.entity.Result;
import com.ysk.mapper.BuyListMapper;
import com.ysk.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【buy_list(采购单)】的数据库操作Service实现
* @createDate 2023-08-21 17:06:13
*/
@Service
public class BuyListServiceImpl implements BuyListService{


    @Autowired
    private BuyListMapper buyListMapper;

    //添加采购单的业务方法
    @Override
    public Result savePurchase(BuyList purchase) {
        int i = buyListMapper.insertPurchase(purchase);
        if(i > 0){
            return Result.ok("添加采购单成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"添加采购单子失败" );
    }
}




