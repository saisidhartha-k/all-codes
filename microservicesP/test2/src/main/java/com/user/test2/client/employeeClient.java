package com.user.test2.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.user.test2.dto.Employee;

@HttpExchange
public interface employeeClient {
     @GetExchange("/employee/department/{departmentId}")
   public List<Employee> findByDepartment(@PathVariable("departmentId") int departmentId); 
     
    
}
