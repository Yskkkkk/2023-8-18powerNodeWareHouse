package com.ysk.controller;


import com.google.code.kaptcha.Producer;
import com.ysk.entity.*;
import com.ysk.service.AuthService;
import com.ysk.service.UserService;
import com.ysk.utils.DigestUtil;
import com.ysk.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    //注入DefaultKaptcha的bean对象--生成验证码图片
    @Resource(name="captchaProducer")
    private Producer producer;

    //注入redis模板
    @Autowired
    private StringRedisTemplate redisTemplate;

    //注入tokenUtils的bean对象
    @Autowired
    private TokenUtils tokenUtils;
    //生成验证码图片
    @RequestMapping("/captcha/captchaImage")
    public void captchaImage(HttpServletResponse response){

        ServletOutputStream out = null;
        try{
            //生成验证码图片的文件
            String text = producer.createText();
            //使用验证码文本生成验证码图片
            BufferedImage image = producer.createImage(text);
            //将验证码文本保存到redis -- 设置键的过期时间为30分钟
            redisTemplate.opsForValue().set(text,"",1800, TimeUnit.SECONDS);

            /*
            将验证码图片响应给前端
            */
            //设置响应正文image/jpeg
            response.setContentType("image/jpeg");
            //将照片写给前端
            out = response.getOutputStream();
            ImageIO.write(image,"jpg",out);
            //刷新
            out.flush();
        }  catch(IOException e){
            e.printStackTrace();
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        登录的url接口
        参数@RequestBody LoginUser loginUser 表示接收并封装前端传递过来的用户json信息
        返回的Result对象，表示向前端响应结果Result的json串，包含响应状态，成功失败响应，响应信息，响应数据
    */

    //注入UserService
    @Autowired
    private UserService userService;
    //注入TokenUtils的bean对象
    @RequestMapping("/login")
    public Result login(@RequestBody LoginUser loginUser){

        //拿到客户录入的验证码
        String code = loginUser.getVerificationCode();
        if(!redisTemplate.hasKey(code)){
            return Result.err(Result.CODE_ERR_BUSINESS,"验证码错误");
        }
        //根据账号查询用户
        User user = userService.queryUserByCode(loginUser.getUserCode());
        if(user != null ){//账号存在
            if(user.getUserState().equals(WarehouseConstants.USER_STATE_PASS)){//用户已审核
                //拿到用户录入的密码
                String userPwd = loginUser.getUserPwd();
                //进行md5加密
                userPwd = DigestUtil.hmacSign(userPwd);
                if(userPwd.equals(user.getUserPwd())){//密码合法
                    //生成jwt token并存储到了redis
                    CurrentUser currentUser = new CurrentUser(user.getUserId(),user.getUserCode(),user.getUserName());
                    String token = tokenUtils.loginSign(currentUser, user.getUserPwd());
                    //向客户端响应jwt token
                    return Result.ok("登录成功",token);
                }else{//密码错误
                    return Result.err(Result.CODE_ERR_BUSINESS,"密码错误");
                }
            }else{//用户未审核
                return Result.err(Result.CODE_ERR_BUSINESS,"用户未审核");
            }
        }else{//账号不存在
            return Result.err(Result.CODE_ERR_BUSINESS,"账号不存在");
        }
    }

    /*
    获取当前登录用户信息url接口/curr-user
    参数 @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token
    表示将前端Token的值(前端归还的token值赋值给请求处理方法注入参变量token)
     */
    @Autowired
    private AuthService authService;
    @RequestMapping("/curr-user")
    public Result currentUser(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        return Result.ok(currentUser);
    }

    //加载用户权限菜单树的url接口/user/auth-list
    @RequestMapping("/user/auth-list")
    public Result loadAuthTree(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        //拿到当前登录用户id
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int userId = currentUser.getUserId();
        List<Auth> authTreeList = authService.authTreeByUid(userId);
        return Result.ok(authTreeList);
    }

    @RequestMapping("/logout")
    public Result logout(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){
        //从redis中删除token的键
        redisTemplate.delete(token);
        return Result.ok("退出系统");

    }
}
