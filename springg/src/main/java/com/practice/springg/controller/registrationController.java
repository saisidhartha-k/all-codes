package com.practice.springg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springg.dto.userDto;
import com.practice.springg.entity.User;
import com.practice.springg.service.userService;

@RestController
public class registrationController {
    @Autowired
    private userService userservice;

    @PostMapping("/register")
    public String register(@RequestBody userDto userdto)
    {
        userservice.register(userdto);
        return "OK";
    }
}
