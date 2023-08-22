package com.ysk.service;

import com.ysk.entity.OutStore;
import com.ysk.entity.Result;
import com.ysk.page.Page;

/**
* @author admin
* @description 针对表【out_store(出库单)】的数据库操作Service
* @createDate 2023-08-21 17:17:04
*/
public interface OutStoreService  {

    //添加出库单的业务方法
    public Result saveOutStore(OutStore outStore);


    //分页查询出库单的业务方法
    public Page outStorePage(Page page, OutStore outStore);

    //确定出库的业务方法
    public Result confirmOutStore(OutStore outStore);
}
