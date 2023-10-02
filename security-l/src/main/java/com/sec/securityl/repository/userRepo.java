package com.sec.securityl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec.securityl.entity.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
