package com.ysk.mapper;

import com.ysk.entity.Product;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【product(商品表)】的数据库操作Mapper
* @createDate 2023-08-20 21:27:54
* @Entity com.ysk.entity.Product
*/
@Mapper
public interface ProductMapper  {

    //查询商品行数的方法
    public Integer findProductRowCount(Product product);

    //分页查询商品的方法
    public List<Product> findProductPage(@Param("page") Page page, @Param("product")Product product);
}




