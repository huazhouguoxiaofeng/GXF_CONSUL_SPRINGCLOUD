package com.gxf.user.bean.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRtnMsgConfig {

    @Bean
    public MyResponseBodyWrapFactoryBean getResponseBodyWrap(){

        return new MyResponseBodyWrapFactoryBean();

    }


}
