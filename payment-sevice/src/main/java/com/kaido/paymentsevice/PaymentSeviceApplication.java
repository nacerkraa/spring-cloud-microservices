package com.kaido.paymentsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentSeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSeviceApplication.class, args);
    }

}
