package com.ysk.service.impl;

import com.ysk.entity.Place;
import com.ysk.mapper.PlaceMapper;
import com.ysk.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【place(产地)】的数据库操作Service实现
* @createDate 2023-08-20 19:09:02
*/
@Service
@CacheConfig(cacheNames = "com.ysk.service.impl.PlaceServiceImpl")
public class PlaceServiceImpl implements PlaceService{

    //注入PlaceMapper
    @Autowired
    private PlaceMapper placeMapper;

    /*
      查询所有产地的业务方法
     */
    //对查询到的所有产地进行缓存,缓存到redis的键为all:place
    @Cacheable(key = "'all:place'")
    @Override
    public List<Place> queryAllPlace() {
        //查询所有产地
        return placeMapper.findAllPlace();
    }
}




