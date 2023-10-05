package com.example.checkout.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface cycleClient {
    @GetExchange("api/cycles/loggedInUser")
    String getUser(@RequestHeader("Authorization") String token);

}