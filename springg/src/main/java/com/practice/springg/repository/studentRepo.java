package com.practice.springg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springg.entity.Student;

@Repository
public interface studentRepo extends JpaRepository<Student,Integer> {
    
}
