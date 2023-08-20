package com.ysk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysk.entity.Place;
import com.ysk.service.PlaceService;
import com.ysk.mapper.PlaceMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【place(产地)】的数据库操作Service实现
* @createDate 2023-08-20 19:09:02
*/
@Service
public class PlaceServiceImpl extends ServiceImpl<PlaceMapper, Place>
    implements PlaceService{

}




