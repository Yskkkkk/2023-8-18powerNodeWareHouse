package com.ysk.service;

import com.ysk.entity.Result;
import com.ysk.entity.Store;
import com.ysk.page.Page;

import java.util.List;

/**
* @author admin
* @description 针对表【store(仓库表)】的数据库操作Service
* @createDate 2023-08-20 19:02:09
*/
public interface StoreService  {

    //查询所有仓库的业务
    public List<Store> queryAllStore();

    //分页查询仓库的业务方法
    public Page queryStorePage(Page page, Store store);

    //检验仓库编码是否存在的业务方法
    public Result queryStoreByNum(String storeNum);

    //添加仓库的业务方法
    public Result saveStore(Store store);

    //修改仓库
    public Result updateStore(Store store);

    //删除仓库
    public Result deleteStore(Integer storeId);
}
