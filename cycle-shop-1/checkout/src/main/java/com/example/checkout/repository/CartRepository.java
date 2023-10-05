package com.example.checkout.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.checkout.dto.Cart;
import com.example.checkout.dto.User;

public interface CartRepository extends JpaRepository<Cart,Long>{

    Optional<Cart> findByUser(User user);
    
}
