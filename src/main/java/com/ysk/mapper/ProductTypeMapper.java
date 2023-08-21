package com.ysk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysk.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【product_type(商品分类表)】的数据库操作Mapper
* @createDate 2023-08-20 19:06:27
* @Entity com.ysk.entity.ProductType
*/
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    //查询所有商品分类的方法
    public List<ProductType> findAllProductType();

    //根据分类编码查询商品分类的方法
    public ProductType findTypeByCode(String typeCode);

    //添加商品分类的方法
    public int insertProductType(ProductType productType);

    //根据分类id删除分类及其所有子级分类的方法
    public int deleteProductType(Integer typeId);

    //根据分类id修改分类的方法
    public int updateTypeById(ProductType productType);
}




