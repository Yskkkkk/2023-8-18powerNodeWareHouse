package com.ysk.mapper;

import com.ysk.entity.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【place(产地)】的数据库操作Mapper
* @createDate 2023-08-20 19:09:02
* @Entity com.ysk.entity.Place
*/
@Mapper
public interface PlaceMapper {

    //查询所有产地
    public List<Place> findAllPlace();

}




