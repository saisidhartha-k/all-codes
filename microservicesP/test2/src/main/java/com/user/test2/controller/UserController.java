package com.user.test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.test2.client.employeeClient;
import com.user.test2.dto.Dept;
import com.user.test2.repository.deptRepo;

@RestController
@RequestMapping("/dept")
public class UserController {

    @Autowired
    private deptRepo deptRepo;

    @Autowired
    private employeeClient employeeClient;

    @GetMapping("/allDepts")
    public List<Dept> getDepts() {
        return deptRepo.findAll();
    }

    @PostMapping("/add")
    public Dept add (@RequestBody Dept dept)
    {
        return deptRepo.addDept(dept);
    }

    @GetMapping("/dept/{id}")
    public Dept findByid(@PathVariable int id)
    {
            return deptRepo.findById(id);
    }

     @GetMapping("/withEmp")
    public List<Dept> withEmp() {
        List<Dept> depts = deptRepo.findAll();

        depts.forEach(dept -> 
        dept.setEmployee(
            employeeClient.findByDepartment(dept.getId())
        ));
        
        return depts;
    }
}