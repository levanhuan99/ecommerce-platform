package com.ecommerce.notification_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @GetMapping("/health")
    public String helloOrder() {
        System.out.println("say hi");
        return "Hello from Order Service!";
    }
}
