package com.user.test2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.user.test2.dto.Dept;

@Repository
public class deptRepo  {
      private List<Dept> depts = new ArrayList<>();

    public Dept addDept(Dept dept)
    {
        depts.add(dept);
        return dept;
    }


    public Dept findById(int id) {
        return depts.stream()
                .filter(dept -> dept.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No department with id " + id + " found"));
    }
    
    public List<Dept> findAll()
    {
        return depts;
    }

}
