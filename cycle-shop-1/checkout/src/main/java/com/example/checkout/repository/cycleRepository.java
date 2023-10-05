package com.example.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.checkout.dto.Cycle;

@Repository
public interface cycleRepository extends JpaRepository <Cycle,Integer>{
    
}
