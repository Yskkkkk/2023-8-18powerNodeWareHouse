package com.ysk.controller;

import com.ysk.entity.*;
import com.ysk.page.Page;
import com.ysk.service.BuyListService;
import com.ysk.service.InStoreService;
import com.ysk.service.StoreService;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private BuyListService buyListService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private InStoreService inStoreService;

    @Autowired
    private TokenUtils tokenUtils;
    /**
     * 添加采购单的url接口/purchase/purchase-add
     */
    @RequestMapping("/purchase-add")
    public Result addPurchase(@RequestBody BuyList purchase){
        //执行业务
        Result result = buyListService.savePurchase(purchase);
        //响应
        return result;
    }

    /**
     * 查询所有仓库的url接口/purchase/store-list
     */
    @RequestMapping("/store-list")
    public Result stortList(){

        List<Store> storeList = storeService.queryAllStore();

        return Result.ok(storeList);
    }

    /**
     * 删除采购单的url接口/purchase/purchase-delete/{buyId}
     *
     * @PathVariable Integer buyId将路径占位符buyId的值赋值给参数变量buyId;
     */
    @RequestMapping("/purchase-delete/{buyId}")
    public Result deletePurchase(@PathVariable Integer buyId){
        //执行业务
        Result result = buyListService.deletePurchaseById(buyId);
        //响应
        return result;
    }

    /**
     * 分页查询采购单的url接口/purchase/purchase-page-list
     *
     * 参数Page对象用于接收请求参数页码pageNum、每页行数pageSize;
     * 参数Purchase对象用于接收请求参数仓库id storeId、商品名称productName、
     * 采购人buyUser、是否生成入库单isIn、起止时间startTime和endTime;
     *
     * 返回值Result对象向客户端响应组装了所有分页信息的Page对象;
     */
    @RequestMapping("/purchase-page-list")
    public Result purchasePageList(Page page, BuyList purchase){
        //执行业务
        page = buyListService.queryPurchasePage(page, purchase);
        //响应
        return Result.ok(page);
    }

    /**
     * 修改采购单的url接口/purchase/purchase-update
     *
     * @RequestBody Purchase purchase将请求传递的json数据封装到参数Purchase对象;
     */
    @RequestMapping("/purchase-update")
    public Result updatePurchase(@RequestBody BuyList buyList){
        //执行业务
        Result result = buyListService.updatePurchase(buyList);
        //响应
        return result;
    }

    /**
     * 添加入库单的url接口/purchase/in-warehouse-record-add
     *
     * @RequestBody Purchase purchase将请求传递的json数据封装到参数Purchase对象;
     * @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token
     * 将请求头Token的值即客户端归还的token赋值给参数变量token;
     */
    @RequestMapping("/in-warehouse-record-add")
    public Result addInStore(@RequestBody BuyList purchase,
                             @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id -- 创建入库单的用户id
        int createBy = currentUser.getUserId();

        //创建InStore对象封装添加的入库单的信息
        InStore inStore = new InStore();
        inStore.setStoreId(purchase.getStoreId());
        inStore.setProductId(purchase.getProductId());
        inStore.setInNum(purchase.getFactBuyNum());
        inStore.setCreateBy(createBy);

        //执行业务
        Result result = inStoreService.saveInStore(inStore, purchase.getBuyId());

        //响应
        return result;
    }
}
