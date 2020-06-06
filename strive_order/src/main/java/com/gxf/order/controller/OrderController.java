package com.gxf.order.controller;

import com.gxf.order.service.OrderService;
import com.gxf.product.api.ProductApi;
import com.gxf.product.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

//VM options: -Deserver.port=?

    public static final String INVOKE_URL = "http://strive-product/product/find-by-id";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value="获取用户详情", notes="获取用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/order-product-by-ribbon/{id}")
    public String orderProductByRibbon(@PathVariable long id){

        String result = restTemplate.getForObject(INVOKE_URL,String.class);
//        return result;

//        UserEntity userEntity = userServiceI.getUserById(id);
//        return "SUCCESS: " + serverPort + ": id" + id;
        return result;
    }

    @ApiOperation(value="获取用户详情", notes="获取用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/order-product-by-feign/{id}")
    public String orderProductByFeign(@PathVariable long id){

        String byId = orderService.findById(id);

//        String result = restTemplate.getForObject(INVOKE_URL,String.class);
//        return result;

//        UserEntity userEntity = userServiceI.getUserById(id);
//        return "SUCCESS: " + serverPort + ": id" + id;
        return byId;
    }

}
