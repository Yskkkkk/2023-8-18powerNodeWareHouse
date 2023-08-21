package com.ysk.service.impl;

import com.ysk.entity.Unit;
import com.ysk.mapper.UnitMapper;
import com.ysk.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【unit(规格单位表)】的数据库操作Service实现
* @createDate 2023-08-20 19:09:14
*/
//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名
@CacheConfig(cacheNames = "com.ysk.service.impl.UnitServiceImpl")
@Service
public class UnitServiceImpl implements UnitService {

    //注入UnitMapper
    @Autowired
    private UnitMapper unitMapper;

    /*
      查询所有单位的业务方法
     */
    //对查询到的所有单位进行缓存,缓存到redis的键为all:unit
    @Cacheable(key = "'all:unit'")
    @Override
    public List<Unit> queryAllUnit() {
        //查询所有单位
        return unitMapper.findAllUnit();
    }
}




