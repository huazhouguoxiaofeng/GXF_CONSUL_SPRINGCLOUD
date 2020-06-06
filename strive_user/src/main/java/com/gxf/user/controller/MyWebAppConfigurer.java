package com.gxf.user.controller;

import com.gxf.user.interceptor.InterceptorConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目启动时就要定义好对哪个类进行拦截
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
    }

}
