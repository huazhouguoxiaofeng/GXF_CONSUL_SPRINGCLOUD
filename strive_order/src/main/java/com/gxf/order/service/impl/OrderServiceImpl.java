package com.gxf.order.service.impl;

import com.gxf.order.service.OrderService;
import com.gxf.product.api.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductApi productApi;

    @Override
    public String findById(long id) {
        return productApi.findById(id);
    }
}
