package com.gxf.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务客户端
 */
//@FeignClient(name = "product-com.gxf.product.service",fallback = ProductClientFallback.class)
//@FeignClient(name = "strive-product")
@Service
public interface ProductService {

//    @GetMapping("/find-by-id")
    String findById(@RequestParam(value = "id") long id);

}
