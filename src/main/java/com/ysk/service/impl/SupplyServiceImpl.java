package com.ysk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysk.entity.Supply;
import com.ysk.service.SupplyService;
import com.ysk.mapper.SupplyMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【supply(供货商)】的数据库操作Service实现
* @createDate 2023-08-20 19:08:18
*/
@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply>
    implements SupplyService{

}




