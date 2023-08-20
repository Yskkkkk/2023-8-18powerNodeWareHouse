package com.ysk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysk.entity.ProductType;
import com.ysk.service.ProductTypeService;
import com.ysk.mapper.ProductTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【product_type(商品分类表)】的数据库操作Service实现
* @createDate 2023-08-20 19:06:27
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{

}




