package com.ysk.service;

import com.ysk.entity.Brand;

import java.util.List;

/**
* @author admin
* @description 针对表【brand(品牌)】的数据库操作Service
* @createDate 2023-08-20 19:05:19
*/
public interface BrandService  {

    //查询所有品牌的业务方法
    public List<Brand> queryAllBrand();
}
