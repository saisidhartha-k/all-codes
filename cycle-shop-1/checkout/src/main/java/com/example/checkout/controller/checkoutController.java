package com.example.checkout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.service.annotation.GetExchange;

import com.example.checkout.client.cycleClient;
import com.example.checkout.dto.Items;
import com.example.checkout.service.checkoutService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class checkoutController {

    @Autowired
    private cycleClient cycleClient;

    @Autowired
    private checkoutService checkoutService;

    @GetMapping("/user")
    public String getUser() {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYSIsImV4cCI6MTY5NjMxNTQxOCwiaWF0IjoxNjk2MzExODE4LCJzY29wZSI6IlJPTEVfQURNSU4ifQ.YsJw2-YtPMzrlJdlI9rU1x1BGKgLLnD8Cr7Xhp-u-29sUDb7WxgAuMjUqJlnhRejthsC5LAgKQl4cb74SCDPLaR23b1XKDCBXzw7pcyZCJ4x8Xu7Y9Jdljndaw4JarLNnPFebmOhSEfdxfUUHArK-NmK_1NUzR09lxq8NNkqjWAq-iZSX25OxC2d6HIjSHXxQQmsTzNU6smLtfe-DeYDHBbdyL_kMcyK7zZACKLLv4U7nE8s3ulwJvghH_WoSHSBHERJnmC0misyo6gDm1pX3bFxDubyco2BqrU33tfSG2XjlS4UpkCBe7IlMCivdkfBs32Krs1oqONUuidahrT-aA";
        return cycleClient.getUser(token);
    }

    @GetMapping("/test")
    public String Test() {
        return "hi";
    }

    @PostMapping("/checkout")
    public List<Items> checkOut() {
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = getUser();
        List<Items> items = checkoutService.checkOut(name);
        if (items != null) {
            return items;
        } else {

            return new ArrayList<>();
        }
    }

}
