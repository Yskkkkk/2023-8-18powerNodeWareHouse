package com.ysk.service;

import com.ysk.entity.Store;

import java.util.List;

/**
* @author admin
* @description 针对表【store(仓库表)】的数据库操作Service
* @createDate 2023-08-20 19:02:09
*/
public interface StoreService  {

    //查询所有仓库的业务
    public List<Store> queryAllStore();
}
