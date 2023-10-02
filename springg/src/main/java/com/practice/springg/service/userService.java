package com.practice.springg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.springg.dto.userDto;
import com.practice.springg.entity.User;
import com.practice.springg.repository.userRepo;

@Service
public class userService {

    @Autowired
    private userRepo userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User register(userDto userdto) {
        User user = new User();
        user.setName(userdto.getName());
        user.setPassword((userdto.getPassword()));
        user.setRole("USER");
        
        userrepo.save(user);
        return user;
    }
    
}
