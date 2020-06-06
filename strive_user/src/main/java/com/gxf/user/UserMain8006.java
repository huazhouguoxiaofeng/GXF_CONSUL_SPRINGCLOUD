package com.gxf.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther zzyy
 * @create 2020-02-19 16:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.gxf.user.mapper")
public class UserMain8006
{
    public static void main(String[] args) {
            SpringApplication.run(UserMain8006.class, args);
    }
}
