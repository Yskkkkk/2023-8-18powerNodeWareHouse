package com.ysk.mapper;

import com.ysk.entity.OutStore;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【out_store(出库单)】的数据库操作Mapper
* @createDate 2023-08-21 17:17:04
* @Entity com.ysk.entity.OutStore
*/
@Mapper
public interface OutStoreMapper  {

    //添加出库单的方法
    public int insertOutStore(OutStore outStore);
}




