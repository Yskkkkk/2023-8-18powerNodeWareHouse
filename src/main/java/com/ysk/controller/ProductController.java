package com.ysk.controller;


import com.ysk.entity.Brand;
import com.ysk.entity.Product;
import com.ysk.entity.Result;
import com.ysk.entity.Store;
import com.ysk.page.Page;
import com.ysk.service.BrandService;
import com.ysk.service.ProductService;
import com.ysk.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;
    //查询所有仓库的url接口/produce/store-list
    @RequestMapping("/store-list")
    public Result storeList(){
        List<Store> storeList = storeService.queryAllStore();
        return Result.ok("查询成功",storeList);
    }


    /**
     * 查询所有品牌的url接口/product/brand-list
     *
     * 返回值Result对象给客户端响应查询到的List<Brand>;
     */
    @RequestMapping("/brand-list")
    public Result brandList(){
        //执行业务
        List<Brand> brandList = brandService.queryAllBrand();
        //响应
        return Result.ok(brandList);
    }

    //分页查询商品的url接口/product/product-page-list
    @RequestMapping("/product-page-list")
    public Result productListPage(Page page, Product product){
        page = productService.queryProductPage(page, product);
        return Result.ok(page);
    }
}
