package com.ysk.service.impl;

import com.ysk.entity.Product;
import com.ysk.mapper.ProductMapper;
import com.ysk.page.Page;
import com.ysk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2023-08-20 21:27:54
*/
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    //分页查询商品的业务方法
    @Override
    public Page queryProductPage(Page page, Product product) {

        //查询商品行数
        Integer count = productMapper.findProductRowCount(product);
        //分页查询商品
        List<Product> productList = productMapper.findProductPage(page, product);

        page.setTotalNum(count);
        page.setResultList(productList);
        return page;
    }
}




