package com.ysk.service;

import com.ysk.entity.Product;
import com.ysk.page.Page;

/**
* @author admin
* @description 针对表【product(商品表)】的数据库操作Service
* @createDate 2023-08-20 21:27:54
*/
public interface ProductService  {

    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);

}
