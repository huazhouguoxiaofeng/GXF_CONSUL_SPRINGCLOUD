package com.gxf.user.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class InterceptorConfig implements HandlerInterceptor {

    /**
     * 若返回false，则不会走进Controller方法里面了，也不会走 postHandle 以及 afterCompletion 这两个方法的了,因为直接拦截返回了嘛
     * 若返回true，则进入 Controller postHandle  以及 afterCompletion 方法
     * 若返回true：
     *      DispatcherServlet进行视图的渲染之前：调用 postHandle 方法
     *      DispatcherServlet进行视图的渲染之后：调用 afterCompletion 方法
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info(" \n 访问方法之前，首先调用preHandle拦截器");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        log.info(" \n DispatcherServlet进行视图的渲染之前：调用 postHandle 方法，调用 postHandle 拦截器");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        log.info(" \n DispatcherServlet进行视图的渲染之后：调用 afterCompletion 方法，调用 afterCompletion 拦截器");
    }

}