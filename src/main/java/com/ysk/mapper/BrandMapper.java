package com.ysk.mapper;

import com.ysk.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【brand(品牌)】的数据库操作Mapper
* @createDate 2023-08-20 19:05:19
* @Entity com.ysk.entity.Brand
*/
@Mapper
public interface BrandMapper  {

    //查询所有品牌的方法
    public List<Brand> findAllBrand();
}




