package com.kaido.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private int id;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
