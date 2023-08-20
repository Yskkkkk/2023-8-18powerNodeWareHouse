package com.ysk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysk.entity.Unit;
import com.ysk.service.UnitService;
import com.ysk.mapper.UnitMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【unit(规格单位表)】的数据库操作Service实现
* @createDate 2023-08-20 19:09:14
*/
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{

}




