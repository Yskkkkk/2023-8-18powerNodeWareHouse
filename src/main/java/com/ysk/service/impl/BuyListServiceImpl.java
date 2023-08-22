package com.ysk.service.impl;

import com.ysk.entity.BuyList;
import com.ysk.entity.Result;
import com.ysk.mapper.BuyListMapper;
import com.ysk.page.Page;
import com.ysk.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //删除采购单的方法
    @Override
    public Result deletePurchaseById(Integer buyId) {
        int i = buyListMapper.deleteById(buyId);
        if(i > 0){
            return Result.ok("采购单删除成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "采购单删除失败！");
    }

    //分页查询采购单的业务方法
    @Override
    public Page queryPurchasePage(Page page, BuyList buyList) {
        //查询采购单总行数
        int purchaseCount = buyListMapper.selectPurchaseCount(buyList);

        //分页查询采购单
        List<BuyList> purchaseList = buyListMapper.selectPurchasePage(page, buyList);

        //将查询到的总行数和当前页数据组装到Page对象
        page.setTotalNum(purchaseCount);
        page.setResultList(purchaseList);
        return page;
    }

    @Override
    public Result updatePurchase(BuyList buyList) {
        int i = buyListMapper.updatePurchaseById(buyList);
        if(i>0){
            return Result.ok("采购单修改成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "采购单修改失败！");
    }
}




