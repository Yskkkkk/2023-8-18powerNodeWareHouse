package com.ysk.mapper;

import com.ysk.entity.InStore;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【in_store(入库单)】的数据库操作Mapper
* @createDate 2023-08-21 19:10:37
* @Entity com.ysk.entity.InStore
*/
@Mapper
public interface InStoreMapper {

    //添加入库单的方法
    public int insertInStore(InStore inStore);

    //查询入库单总行数的方法
    public int selectInStoreCount(InStore inStore);

    //分页查询入库单的方法
    public List<InStore> selectInStorePage(@Param("page") Page page,
                                           @Param("inStore") InStore inStore);

    //根据id将入库单状态改为已入库的方法
    public int updateIsInById(Integer insId);
}




