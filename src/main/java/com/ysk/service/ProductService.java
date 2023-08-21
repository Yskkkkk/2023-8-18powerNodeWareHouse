package com.ysk.service;

import com.ysk.entity.Product;
import com.ysk.entity.Result;
import com.ysk.page.Page;

import java.util.List;

/**
* @author admin
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2023-08-20 21:27:54
*/
public interface ProductService  {

    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);


    //添加商品的业务方法
    public Result saveProduct(Product product);

    //修改商品上下架状态的业务方法
    public Result updateProductState(Product product);

    //删除商品
    public Result deleteProductById(List<Integer> productId);

    //修改商品的业务方法
    public Result updateProduct(Product product);
}
