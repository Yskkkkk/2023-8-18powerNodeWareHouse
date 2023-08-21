package com.ysk.controller;


import com.ysk.entity.*;
import com.ysk.page.Page;
import com.ysk.service.*;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private TokenUtils tokenUtils;
    //查询所有仓库的url接口/produce/store-list
    @RequestMapping("/store-list")
    public Result storeList(){
        List<Store> storeList = storeService.queryAllStore();
        return Result.ok("查询成功",storeList);
    }


    /**
     * 查询所有品牌的url接口/product/brand-list
     *
     * 返回值Result对象给客户端响应查询到的List<Brand>;
     */
    @RequestMapping("/brand-list")
    public Result brandList(){
        //执行业务
        List<Brand> brandList = brandService.queryAllBrand();
        //响应
        return Result.ok(brandList);
    }

    //分页查询商品的url接口/product/product-page-list
    @RequestMapping("/product-page-list")
    public Result productListPage(Page page, Product product){
        page = productService.queryProductPage(page, product);
        return Result.ok(page);
    }

    //查询所有商品分类树 /product/category-tree
    @RequestMapping("/category-tree")
    public Result categoryTree(){

        List<ProductType> productTypes = productTypeService.productTypeTree();

        return Result.ok(productTypes);
    }

    /**
     * 查询所有供应商的url接口/product/supply-list
     *
     * 返回值Result对象给客户端响应查询到的List<Supply>;
     */
    @RequestMapping("/supply-list")
    public Result supplyList(){
        //执行业务
        List<Supply> supplyList = supplyService.queryAllSupply();
        //响应
        return Result.ok(supplyList);
    }

    //注入PlaceService
    @Autowired
    private PlaceService placeService;

    /**
     * 查询所有产地的url接口/product/place-list
     *
     * 返回值Result对象给客户端响应查询到的List<Place>;
     */
    @RequestMapping("/place-list")
    public Result placeList(){
        //执行业务
        List<Place> placeList = placeService.queryAllPlace();
        //响应
        return Result.ok(placeList);
    }


    //注入UnitService
    @Autowired
    private UnitService unitService;

    /**
     * 查询所有单位的url接口/product/unit-list
     *
     * 返回值Result对象给客户端响应查询到的List<Unit>;
     */
    @RequestMapping("/unit-list")
    public Result unitList(){
        //执行业务
        List<Unit> unitList = unitService.queryAllUnit();
        //响应
        return Result.ok(unitList);
    }

    /**
     * 将配置文件的file.upload-path属性值注入给控制器的uploadPath属性,
     * 其为图片上传到项目的目录路径(类路径classes即resources下的static/img/upload);
     */
    @Value("${file.upload-path}")
    private String uploadPath;

    /**
     * 上传图片的url接口/product/img-upload
     *
     * 参数MultipartFile file对象封装了上传的图片;
     *
     * @CrossOrigin表示该url接口允许跨域请求;
     */
    @CrossOrigin
    @PostMapping("/img-upload")
    public Result uploadImg(MultipartFile file){

        try {
            //拿到图片上传到的目录(类路径classes下的static/img/upload)的File对象
            File uploadDirFile = ResourceUtils.getFile(uploadPath);
            //拿到图片上传到的目录的磁盘路径
            String uploadDirPath = uploadDirFile.getAbsolutePath();
            //拿到图片保存到的磁盘路径
            String fileUploadPath = uploadDirPath + "\\" + file.getOriginalFilename();
            //保存图片
            file.transferTo(new File(fileUploadPath));
            //成功响应
            return Result.ok("图片上传成功！");
        } catch (IOException e) {
            //失败响应
            return Result.err(Result.CODE_ERR_BUSINESS, "图片上传失败！");
        }
    }


    /**
     * 添加商品的url接口/product/product-add
     *
     * @RequestBody Product product将添加的商品信息的json串数据封装到参数Product对象;
     * @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token
     * 将请求头Token的值即客户端归还的token赋值给参数变量token;
     */
    @RequestMapping("/product-add")
    public Result addProduct(@RequestBody Product product,
                             @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){

        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即添加商品的用户id
        int createBy = currentUser.getUserId();
        product.setCreateBy(createBy);

        //执行业务
        Result result = productService.saveProduct(product);

        //响应
        return result;
    }

    /**
     * 修改商品上下架状态的url接口/product/state-change
     *
     * @RequestBody Product product用于接收并封装请求json数据;
     */
    @RequestMapping("/state-change")
    public Result changeProductState(@RequestBody Product product){
        //执行业务
        Result result = productService.updateProductState(product);
        //响应
        return result;
    }

    /**
     * 删除商品的url接口/product/product-delete/{productId}
     */
    @RequestMapping("/product-delete/{productId}")
    public Result deleteProduct(@PathVariable Integer productId){

        //执行业务
        Result result = productService.deleteProductById(Arrays.asList(productId));
        //响应
        return result;
    }

    //批量删除
    @RequestMapping("/product-list-delete")
    public Result deleteProductByIds(@RequestBody List<Integer> productIds){

        Result result = productService.deleteProductById(productIds);

        return result;
    }

    /**
     * 修改商品的url接口/product/product-update
     *
     * @RequestBody Product product将请求传递的json数据封装到参数Product对象;
     * @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token
     * 将请求头Token的值即客户端归还的token赋值给参数变量token;
     */
    @RequestMapping("/product-update")
    public Result updateProduct(@RequestBody Product product,
                                @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){

        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即修改商品的用户id
        int updateBy = currentUser.getUserId();
        product.setUpdateBy(updateBy);

        //执行业务
        Result result = productService.updateProduct(product);

        //响应
        return result;
    }
}
