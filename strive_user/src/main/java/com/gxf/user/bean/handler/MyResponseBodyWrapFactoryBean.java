package com.gxf.user.bean.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/**
 * 设置bean过滤原则
 */
public class MyResponseBodyWrapFactoryBean implements InitializingBean{

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);


    }


    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers){

        for(HandlerMethodReturnValueHandler handler : handlers){
            if(handler instanceof RequestResponseBodyMethodProcessor){
                MyResponseBodyWrapHandler decorator = new MyResponseBodyWrapHandler(handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                break;
            }
        }

    }

}
