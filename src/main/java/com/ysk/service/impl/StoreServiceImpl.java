package com.ysk.service.impl;

import com.ysk.entity.Result;
import com.ysk.entity.Store;
import com.ysk.mapper.StoreMapper;
import com.ysk.page.Page;
import com.ysk.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【store(仓库表)】的数据库操作Service实现
* @createDate 2023-08-20 19:02:09
*/
@CacheConfig(cacheNames = "com.ysk.service.impl.StoreServiceImpl")
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreMapper storeMapper;
    //查询所有仓库的业务
//    public List<Store> queryAllStore();
    @Cacheable(key = "'all:store'")
    @Override
    public List<Store> queryAllStore() {
        return storeMapper.findAllStore();
    }


    @Override
    public Page queryStorePage(Page page, Store store) {
        //查询仓库总行数
        int storeCount = storeMapper.selectStoreCount(store);

        //分页查询仓库
        List<Store> storeList = storeMapper.selectStorePage(page, store);

        //将查到的总行数和当前页数据封装到Page对象
        page.setTotalNum(storeCount);
        page.setResultList(storeList);

        return page;
    }

    //检验仓库编码是否存在的业务方法
    @Override
    public Result queryStoreByNum(String storeNum) {
        Store store = storeMapper.selectByStoreNum(storeNum);
        return Result.ok(store==null);
    }

    //添加仓库的业务方法
    @Override
    public Result saveStore(Store store) {
        //添加仓库
        int i = storeMapper.insertStore(store);
        if(i>0){
            return Result.ok("仓库添加成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "仓库添加失败！");
    }

    //修改仓库
    @Override
    public Result updateStore(Store store){
        int i = storeMapper.updateById(store);
        if(i>0){
            return Result.ok("仓库修改成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "仓库修改失败！");
    }


    //删除仓库
    @Override
    public Result deleteStore(Integer storeId) {
        int i = storeMapper.deleteById(storeId);
        if(i>0){
            return Result.ok("仓库删除成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "仓库删除失败！");
    }


}




