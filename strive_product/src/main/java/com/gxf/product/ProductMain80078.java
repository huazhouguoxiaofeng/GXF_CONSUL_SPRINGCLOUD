package com.gxf.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther zzyy
 * @create 2020-02-19 16:05
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class ProductMain80078
{
    public static void main(String[] args) {
            SpringApplication.run(ProductMain80078.class, args);
    }
}
