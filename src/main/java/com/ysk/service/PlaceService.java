package com.ysk.service;

import com.ysk.entity.Place;

import java.util.List;

/**
* @author admin
* @description 针对表【place(产地)】的数据库操作Service
* @createDate 2023-08-20 19:09:02
*/
public interface PlaceService  {

    //查询所有产地的业务方法
    public List<Place> queryAllPlace();

}
