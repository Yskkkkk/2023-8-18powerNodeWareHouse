package com.ysk.service.impl;

import com.ysk.entity.InStore;
import com.ysk.entity.Result;
import com.ysk.mapper.BuyListMapper;
import com.ysk.mapper.InStoreMapper;
import com.ysk.mapper.ProductMapper;
import com.ysk.page.Page;
import com.ysk.service.InStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author admin
* @description 针对表【in_store(入库单)】的数据库操作Service实现
* @createDate 2023-08-21 19:10:37
*/
@Service
public class InStoreServiceImpl implements InStoreService{

    //注入InStoreMapper
    @Autowired
    private InStoreMapper inStoreMapper;

    //注入PurchaseMapper
    @Autowired
    private BuyListMapper buyListMapper;

    @Autowired
    private ProductMapper productMapper;

    //添加入库单的业务方法
    @Transactional//事务处理
    @Override
    public Result saveInStore(InStore inStore, Integer buyId) {
        //添加入库单
        int i = inStoreMapper.insertInStore(inStore);
        if(i>0){
            //根据id将采购单状态改为已入库
            int j = buyListMapper.updateIsInById(buyId);
            if(j>0){
                return Result.ok("入库单添加成功！");
            }
            return Result.err(Result.CODE_ERR_BUSINESS, "入库单添加失败！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "入库单添加失败！");
    }

    //分页查询入库单的业务方法
    @Override
    public Page queryInStorePage(Page page, InStore inStore) {

        //查询入库单总行数
        int inStoreCount = inStoreMapper.selectInStoreCount(inStore);

        //分页查询入库单
        List<InStore> inStoreList = inStoreMapper.selectInStorePage(page, inStore);

        //将查询到的总行数和当前页数据封装到Page对象
        page.setTotalNum(inStoreCount);
        page.setResultList(inStoreList);

        return page;
    }

    //确定入库的业务方法
    @Transactional//事务处理
    @Override
    public Result confirmInStore(InStore inStore) {

        //根据id将入库单状态改为已入库
        int i = inStoreMapper.updateIsInById(inStore.getInsId());
        if(i>0){
            //根据商品id增加商品库存
            int j = productMapper.addInventById(inStore.getProductId(), inStore.getInNum());
            if(j>0){
                return Result.ok("入库成功！");
            }
            return Result.err(Result.CODE_ERR_BUSINESS, "入库失败！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "入库失败！");
    }
}




