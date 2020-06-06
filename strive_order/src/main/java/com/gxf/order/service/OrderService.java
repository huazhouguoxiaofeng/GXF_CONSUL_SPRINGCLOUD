package com.gxf.order.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    String findById(long id);
}
