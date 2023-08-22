package com.ysk.service;

import com.ysk.entity.InStore;
import com.ysk.entity.Result;
import com.ysk.page.Page;

/**
* @author admin
* @description 针对表【in_store(入库单)】的数据库操作Service
* @createDate 2023-08-21 19:10:37
*/
public interface InStoreService {


    //添加入库单的业务方法
    public Result saveInStore(InStore inStore, Integer buyId);

    //分页查询入库单的业务方法
    public Page queryInStorePage(Page page, InStore inStore);

    //确定入库的业务方法
    public Result confirmInStore(InStore inStore);
}
