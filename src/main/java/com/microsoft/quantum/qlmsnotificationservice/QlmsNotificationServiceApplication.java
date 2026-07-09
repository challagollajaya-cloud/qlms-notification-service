package com.microsoft.quantum.qlmsnotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QlmsNotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                QlmsNotificationServiceApplication.class, args);
    }
}