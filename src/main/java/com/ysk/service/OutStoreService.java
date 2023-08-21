package com.ysk.service;

import com.ysk.entity.OutStore;
import com.ysk.entity.Result;

/**
* @author admin
* @description 针对表【out_store(出库单)】的数据库操作Service
* @createDate 2023-08-21 17:17:04
*/
public interface OutStoreService  {

    //添加出库单的业务方法
    public Result saveOutStore(OutStore outStore);
}
