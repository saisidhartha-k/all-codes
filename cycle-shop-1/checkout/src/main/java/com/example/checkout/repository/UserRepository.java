package com.example.checkout.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.example.checkout.dto.User;

public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findByName(String name);
}
