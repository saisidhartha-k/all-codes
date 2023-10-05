package com.example.checkout.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.example.checkout.dto.Cart;
import com.example.checkout.dto.Checkout;
import com.example.checkout.dto.User;

public interface checkOutRepository extends CrudRepository<Checkout,Integer>{

    Optional<Checkout> findByUser(User user);

   // void delete(Cart cart);

   // void delete(Cart cart);
    
}
