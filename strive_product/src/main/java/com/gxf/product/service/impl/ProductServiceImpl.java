package com.gxf.product.service.impl;

import org.springframework.stereotype.Component;
import com.gxf.product.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    @Override
    public String findById(long id) {

        System.out.println("进入ProductClientFallback方法，feign 调用product-com.gxf.product.service findbyid 异常");

        return "asfsagagasgasgasgasdgasdhgsdhsdf";
    }

}
