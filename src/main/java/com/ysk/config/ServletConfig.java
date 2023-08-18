package com.ysk.config;

//原生servlet的配置类

import com.ysk.filter.LoginCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class ServletConfig {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //创建SecurityFilter对象
        LoginCheckFilter loginCheckFilter = new LoginCheckFilter();
        //给SecurityFilter对象注入redis模板
        loginCheckFilter.setRedisTemplate(redisTemplate);
        //注册SecurityFilter
        filterRegistrationBean.setFilter(loginCheckFilter);
        //配置SecurityFilter拦截所有请求
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
