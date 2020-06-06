package com.gxf.product.controller;

import com.gxf.product.api.ProductApi;
import com.gxf.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
http://localhost:8771/api/v1/product/list
http://localhost:9000/product-service/api/v1/product/list
-Dserver.port=8771
 */

@RestController
@RequestMapping("/product")
public class ProductController implements ProductApi {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping("/find-by-id")
    public String findById(@RequestParam(value = "id") long id) {
        String byId = productService.findById(id);
        return " data from port = " + port + "    :" + byId;
    }
}
