package com.gxf.product.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "strive-product", path = "/product")
public interface ProductApi {

    @GetMapping("/find-by-id")
    String findById(@RequestParam(value = "id") long id);

}
