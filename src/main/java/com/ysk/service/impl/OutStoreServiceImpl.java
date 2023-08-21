package com.ysk.service.impl;

import com.ysk.entity.OutStore;
import com.ysk.entity.Result;
import com.ysk.mapper.OutStoreMapper;
import com.ysk.service.OutStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【out_store(出库单)】的数据库操作Service实现
* @createDate 2023-08-21 17:17:04
*/
@Service
public class OutStoreServiceImpl implements OutStoreService{


    @Autowired
    private OutStoreMapper outStoreMapper;

    //添加出库单
    @Override
    public Result saveOutStore(OutStore outStore) {
        int i = outStoreMapper.insertOutStore(outStore);
        if (i > 0) {
            return Result.ok("添加出库单成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "添加出库单失败！");

    }
}




