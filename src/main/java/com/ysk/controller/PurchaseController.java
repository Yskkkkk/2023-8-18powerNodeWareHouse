package com.ysk.controller;

import com.ysk.entity.BuyList;
import com.ysk.entity.Result;
import com.ysk.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private BuyListService buyListService;

    /**
     * 添加采购单的url接口/purchase/purchase-add
     */
    @RequestMapping("/purchase-add")
    public Result addPurchase(@RequestBody BuyList purchase){
        //执行业务
        Result result = buyListService.savePurchase(purchase);
        //响应
        return result;
    }
}
