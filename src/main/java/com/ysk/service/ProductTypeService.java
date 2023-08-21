package com.ysk.service;

import com.ysk.entity.ProductType;
import com.ysk.entity.Result;

import java.util.List;

/**
* @author admin
* @description 针对表【product_type(商品分类表)】的数据库操作Service
* @createDate 2023-08-20 19:06:27
*/
public interface ProductTypeService {

    //查询商品分类树的方法
    public List<ProductType> productTypeTree();

    //校验分类编码是否已存在的业务方法
    public Result queryTypeByCode(String typeCode);

    //添加商品分类的业务方法
    public Result saveProductType(ProductType productType);

    //删除商品分类的业务方法
    public Result removeProductType(Integer typeId);

    //修改商品分类的业务方法
    public Result updateProductType(ProductType productType);
}
