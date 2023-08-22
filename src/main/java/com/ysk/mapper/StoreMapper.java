package com.ysk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysk.entity.Store;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【store(仓库表)】的数据库操作Mapper
* @createDate 2023-08-20 19:02:09
* @Entity com.ysk.entity.Store
*/
@Mapper
public interface StoreMapper  extends BaseMapper<Store> {

    //查询所有仓库的方法
    public List<Store> findAllStore();

    //查询仓库总行数的方法
    public int selectStoreCount(Store store);

    //分页查询仓库的方法
    public List<Store> selectStorePage(@Param("page") Page page,
                                       @Param("store") Store store);

    //查询仓库编码是否存在
    public Store selectByStoreNum(String storeNum);

    //添加仓库的方法
    public int insertStore(Store store);


}




