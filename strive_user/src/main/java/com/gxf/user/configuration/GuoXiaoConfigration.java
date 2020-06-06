package com.gxf.user.configuration;

import com.gxf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuoXiaoConfigration {

    @Autowired
    private UserService userService;

    /**
     * 服务器启动的时候就调用这个方法
     */
    @Bean
    public void guoxiaoBegin(){
        userService.hahahaha();
    }

    @Bean
    public void cao(){
        System.out.println("项目启动时调用了自动调用了这个方法BBBBB");
    }

}
