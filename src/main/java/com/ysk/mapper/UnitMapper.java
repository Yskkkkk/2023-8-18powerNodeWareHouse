package com.ysk.mapper;

import com.ysk.entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【unit(规格单位表)】的数据库操作Mapper
* @createDate 2023-08-20 19:09:14
* @Entity com.ysk.entity.Unit
*/
@Mapper
public interface UnitMapper  {

    //查询所有单位的方法
    public List<Unit> findAllUnit();
}




