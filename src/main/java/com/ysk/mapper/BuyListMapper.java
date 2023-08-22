package com.ysk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysk.entity.BuyList;
import com.ysk.page.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【buy_list(采购单)】的数据库操作Mapper
* @createDate 2023-08-21 17:06:13
* @Entity com.ysk.entity.BuyList
*/
@Mapper
public interface BuyListMapper extends BaseMapper<BuyList> {

    //添加采购单的方法
    public int insertPurchase(BuyList buyList);

    //查询采购单总行数的方法
    public int selectPurchaseCount(BuyList buyList);

    //分页查询采购单的方法
    public List<BuyList> selectPurchasePage(@Param("page") Page page,
                                            @Param("purchase") BuyList buyList);

    //根据id修改采购单的方法
    public int updatePurchaseById(BuyList buyList);

    //根据id将采购单状态改为已入库的方法
    public int updateIsInById(Integer buyId);
}




