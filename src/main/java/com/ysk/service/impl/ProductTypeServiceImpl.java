package com.ysk.service.impl;

import com.ysk.entity.ProductType;
import com.ysk.entity.Result;
import com.ysk.mapper.ProductTypeMapper;
import com.ysk.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author admin
* @description 针对表【product_type(商品分类表)】的数据库操作Service实现
* @createDate 2023-08-20 19:06:27
*/
@CacheConfig(cacheNames = "com.ysk.service.impl.ProductTypeServiceImpl")
@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Autowired
    private ProductTypeMapper productTypeMapper;

    //查询商品分类树的方法
    @Cacheable(key = "'all:typeTree'")
    @Override
    public List<ProductType> productTypeTree() {
        //查询出所有的商品分类
        List<ProductType> productTypeList = productTypeMapper.findAllProductType();

        //将所有商品分类转成商品分类树
        List<ProductType> productTypes = allTypeToTypeTree(productTypeList, 0);

        return productTypes;
    }

    //校验分类编码是否已存在的业务方法
    @Override
    public Result queryTypeByCode(String typeCode) {

        ProductType productType = productTypeMapper.findTypeByCode(typeCode);

        return Result.ok(productType==null);
    }

    /*
          添加商品分类的业务方法

          @CacheEvict(key = "'all:typeTree'")清除所有商品分类树的缓存;
         */
    @CacheEvict(key = "'all:typeTree'")
    @Override
    public Result saveProductType(ProductType productType) {
        //添加商品分类
        int i = productTypeMapper.insertProductType(productType);
        if(i>0){
            return Result.ok("分类添加成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "分类添加失败！");
    }


    //删除商品分类的业务方法
    @Override
    public Result removeProductType(Integer typeId) {
        int i = productTypeMapper.deleteProductType(typeId);
        if(i > 0){
            return Result.ok("删除成功");
        }
        return Result.err(Result.CODE_ERR_BUSINESS,"删除失败");
    }

        /*
         修改商品分类的业务方法

         @CacheEvict(key = "'all:typeTree'")清除所有商品分类树的缓存;
        */
    @CacheEvict(key = "'all:typeTree'")
    @Override
    public Result updateProductType(ProductType productType) {
        //根据分类id修改分类
        int i = productTypeMapper.updateTypeById(productType);
        if(i>0){
            return Result.ok("分类修改成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "分类修改失败！");
    }


    //将查询到的所有商品分类List<ProductType>转成商品分类树List<ProductType>的算法
    private List<ProductType> allTypeToTypeTree(List<ProductType> allTypeList, Integer parentId){

        //拿到所有一级分类
        List<ProductType> firstLevelType = new ArrayList<>();
        for (ProductType productType : allTypeList) {
            if(productType.getParentId().equals(parentId)){
                firstLevelType.add(productType);
            }
        }

        //查出每个一级分类下的所有二级分类
        for (ProductType productType : firstLevelType) {
            List<ProductType> secondLevelType = allTypeToTypeTree(allTypeList, productType.getTypeId());
            productType.setChildProductCategory(secondLevelType);
        }

        return firstLevelType;
    }
}




