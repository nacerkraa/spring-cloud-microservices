package com.kaido.orderservice.controller;

import com.kaido.orderservice.common.Payment;
import com.kaido.orderservice.common.TransactionRequest;
import com.kaido.orderservice.common.TransactionResponse;
import com.kaido.orderservice.entity.Order;
import com.kaido.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return service.saveOrder(request);
    }
}
