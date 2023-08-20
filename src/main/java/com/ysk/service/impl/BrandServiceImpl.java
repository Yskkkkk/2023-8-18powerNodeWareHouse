package com.ysk.service.impl;

import com.ysk.entity.Brand;
import com.ysk.mapper.BrandMapper;
import com.ysk.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【brand(品牌)】的数据库操作Service实现
* @createDate 2023-08-20 19:05:19
*/
@Service
@CacheConfig(cacheNames = "com.ysk.service.impl.BrandServiceImpl")
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandMapper brandMapper;
    @Override
    @Cacheable(key = "'all:brand'")
    public List<Brand> queryAllBrand() {
        return brandMapper.findAllBrand();
    }
}




