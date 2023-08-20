package com.ysk.service.impl;

import com.ysk.entity.Store;
import com.ysk.mapper.StoreMapper;
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
}




