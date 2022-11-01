package com.mrzachmorgan.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(
    basePackages = "com.mrzachmorgan.clients"
)
@SpringBootApplication(
    scanBasePackages = {
        "com.mrzachmorgan.customer",
        "com.mrzachmorgan.amqp"
    }
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
