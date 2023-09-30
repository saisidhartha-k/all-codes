package com.learn.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.server.entity.Server;
import java.util.List;

public interface serverRepository extends JpaRepository<Server, Integer> {

    Server findByIpAddress(String ipAddress);
    Server findByName(String name);
}
