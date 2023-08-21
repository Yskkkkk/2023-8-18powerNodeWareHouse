package com.ysk.service;

import com.ysk.entity.Unit;

import java.util.List;

/**
* @author admin
* @description 针对表【unit(规格单位表)】的数据库操作Service
* @createDate 2023-08-20 19:09:14
*/
public interface UnitService {
    //查询所有单位的业务方法
    public List<Unit> queryAllUnit();
}
