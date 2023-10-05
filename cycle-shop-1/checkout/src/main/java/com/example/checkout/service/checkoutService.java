package com.example.checkout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.checkout.dto.Cart;
import com.example.checkout.dto.Checkout;
import com.example.checkout.dto.Items;
import com.example.checkout.dto.User;
import com.example.checkout.repository.CartRepository;
import com.example.checkout.repository.UserRepository;
import com.example.checkout.repository.checkOutRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class checkoutService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private checkOutRepository checkoutRepository;

     public List<Items> checkOut(String name) {

        User user = userRepo.findByName(name).get();
        Optional<Cart> cart = cartRepo.findByUser(user);
        List<Items> listItems = new ArrayList<>();
        if (cart.isPresent()) {
            Optional<Checkout> checkout = checkoutRepository.findByUser(user);
            if (checkout.isPresent()) {
                checkout.get().getItems().addAll(cart.get().getItems());
                checkout.get().setTotalPrice(addTotalPrice(cart.get()));
                listItems = checkout.get().getItems();
                checkoutRepository.save(checkout.get());
            }

            else {
                Checkout newCheckout = new Checkout();
                newCheckout.setUser(user);
                newCheckout.getItems().addAll(cart.get().getItems());
                listItems = newCheckout.getItems();
                checkoutRepository.save(newCheckout);
            }

             cartRepo.delete(cart.get());
            return listItems;

        }
        return null;

    }

    private int addTotalPrice(Cart cart) {
        System.out.println(cart.getItems());
        List<Items> item = cart.getItems();
        int total_price = 0;
        for (Items i : item) {
            int temp_price = i.getQuantity() * i.getCycle().getPrice();
            total_price = total_price + temp_price;
        }
        System.out.println(total_price);
        return total_price;
    }
}
