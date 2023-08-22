package com.ysk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ProductMapper extends BaseMapper<Product> {

    //查询商品行数的方法
    public Integer findProductRowCount(Product product);

    //分页查询商品的方法
    public List<Product> findProductPage(@Param("page") Page page, @Param("product")Product product);


    //添加商品的方法
    public int insertProduct(Product product);


    //根据商品id修改商品的上下架状态
    public int updateStateById(Product product);

    //根据商品id修改商品的方法
    public int updateProductById(Product product);

    //根据商品id增加商品库存的方法
    public int addInventById(Integer productId, Integer invent);

    //根据商品id查询商品的方法
    public Product selectProductById(Integer productId);

    //根据商品id减少商品库存的方法
    public int reduceInventById(Integer productId, Integer invent);
}




