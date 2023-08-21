package com.ysk.service.impl;

import com.ysk.entity.Supply;
import com.ysk.mapper.SupplyMapper;
import com.ysk.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【supply(供货商)】的数据库操作Service实现
* @createDate 2023-08-20 19:08:18
*/
@Service
@CacheConfig(cacheNames = "com.ysk.service.impl.SupplyServiceImpl" )
public class SupplyServiceImpl implements SupplyService{
    @Autowired
    private SupplyMapper supplyMapper;

    /*
      查询所有供应商的业务方法
     */
    //对查询到的所有供应商进行缓存,缓存到redis的键为all:supply
    @Cacheable(key = "'all:supply'")
    @Override
    public List<Supply> queryAllSupply() {
        //查询所有供应商
        return supplyMapper.findAllSupply();
    }
}




