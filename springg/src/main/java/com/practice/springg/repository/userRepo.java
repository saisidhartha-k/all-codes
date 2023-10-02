package com.practice.springg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springg.entity.User;

@Repository
public interface userRepo extends JpaRepository<User,Integer> {
    
}
