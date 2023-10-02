package com.practice.springg.business;


import org.springframework.stereotype.Component;

import com.practice.springg.entity.User;

import lombok.Data;

@Data
public class LoggedInUser {
    private User loggedInUser;
}
