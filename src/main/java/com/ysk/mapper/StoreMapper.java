package com.ysk.mapper;

import com.ysk.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【store(仓库表)】的数据库操作Mapper
* @createDate 2023-08-20 19:02:09
* @Entity com.ysk.entity.Store
*/
@Mapper
public interface StoreMapper  {

    //查询所有仓库的方法
    public List<Store> findAllStore();
}




