package com.consumer.test3.repo;


import org.springframework.stereotype.Repository;

import com.consumer.test3.dto.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees
            = new ArrayList<>();

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(int id) {
        return employees.stream()
                .filter(a -> a.id() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(int departmentId) {
        return employees.stream()
                .filter(a -> a.departmentId() == departmentId)
                .toList();
    }
}