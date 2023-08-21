package com.ysk.mapper;

import com.ysk.entity.Supply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【supply(供货商)】的数据库操作Mapper
* @createDate 2023-08-20 19:08:18
* @Entity com.ysk.entity.Supply
*/
@Mapper
public interface SupplyMapper  {

    //查询所有供应商
    public List<Supply> findAllSupply();

}




