package com.kaido.orderservice.service;

import com.kaido.orderservice.common.Payment;
import com.kaido.orderservice.common.TransactionRequest;
import com.kaido.orderservice.common.TransactionResponse;
import com.kaido.orderservice.entity.Order;
import com.kaido.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response="";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        // rest call
        Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful":"field!";
        repository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
