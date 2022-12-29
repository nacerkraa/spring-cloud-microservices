package com.kaido.paymentsevice.controller;

import com.kaido.paymentsevice.entity.Payment;
import com.kaido.paymentsevice.repository.PaymentRepository;
import com.kaido.paymentsevice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return service.doPayment(payment);
    }

    @GetMapping("{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
        return service.findPaymentHistoryByOrderId(orderId);
    }
}
