package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/userinfo")
    public String getUserInfo() {
        String userServiceUrl = "http://user-service/users/info";
        return restTemplate.getForObject(userServiceUrl, String.class);
    }
}
