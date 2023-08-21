package com.ysk.filter;


import com.alibaba.fastjson.JSON;
import com.ysk.entity.Result;
import com.ysk.entity.WarehouseConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//自定义的登录限制过滤器
public class LoginCheckFilter implements Filter {

    //将redis模板定义为其成员变量
    private StringRedisTemplate redisTemplate;

    //成员变量redis模板的set方法
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //过滤器拦截到请求执行的方法
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //1.白名单请求直接放行
        List<String> urlList = new ArrayList<>();

        String url = request.getServletPath();
        urlList.add("/captcha/captchaImage");
        urlList.add("/login");
        urlList.add("/logout");
        //对上传图片的url接口/product/img-upload的请求直接放行
        urlList.add("/product/img-upload");
        if(urlList.contains(url) || url.contains("/img/upload")){//白名单请求
            filterChain.doFilter(request, response);
            return;
        }

        /*
        2.其它请求都校验是否携带token，以及判断redis中是否存在token的键
         */
        String token = request.getHeader(WarehouseConstants.HEADER_TOKEN_NAME);
        //1)有，说明已登录，请求放行
        if(StringUtils.hasText(token)&&redisTemplate.hasKey(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        //2)没有，说明token过期，请求不放行,并给前端做出响应
        Result result = Result.err(Result.CODE_ERR_BUSINESS, "您尚未登录");
        String s = JSON.toJSONString(result);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }
}
