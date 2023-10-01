package com.practice.springg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.springg.entity.Dept;
import java.util.List;

public interface departmentRepository extends JpaRepository<Dept, Integer> {
    Dept findByDeptName(String deptName);

    List<Dept> findAllDeptByDeptName(String deptName);

    @Query("SELECT d FROM Dept d WHERE d.deptName = 'cse' AND d.deptAddress = 'D' ORDER BY d.deptName ASC")
    List<Dept> findAllCseDeptsWithAddressD();

}
