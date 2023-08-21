package com.ysk.service;

import com.ysk.entity.Supply;

import java.util.List;

/**
* @author admin
* @description 针对表【supply(供货商)】的数据库操作Service
* @createDate 2023-08-20 19:08:18
*/
public interface SupplyService  {
    //查询所有供应商的业务方法
    public List<Supply> queryAllSupply();
}
