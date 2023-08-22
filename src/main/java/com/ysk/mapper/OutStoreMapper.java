package com.ysk.mapper;

import com.ysk.entity.OutStore;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //查询出库单总行数的方法
    public int outStoreCount(OutStore outStore);

    //分页查询出库单的方法
    public List<OutStore> outStorePage(@Param("page") Page page,
                                       @Param("outStore") OutStore outStore);

    //根据id将出库单状态改为已出库的方法
    public int updateIsOutById(Integer outsId);
}




