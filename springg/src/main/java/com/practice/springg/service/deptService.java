package com.practice.springg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springg.entity.Dept;
import com.practice.springg.repository.departmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class deptService implements deptServiceimpl {

    @Autowired
    private departmentRepository departmentrepository;

    @Override
    public Dept createDept(Dept dept) {
        System.out.println("Received Dept object: " + dept);

        return departmentrepository.save(dept);
    }

    @Override
    public List<Dept> getDepts(Dept dept) {
        return departmentrepository.findAll();
    }

    public void delete(int id) {
         departmentrepository.deleteById(id);
    }

    @Override
    public Dept update(int id, Dept dept) {
        dept.setId(id);
        return departmentrepository.save(dept);
    }

    @Override
    public List<Dept> findname(String name) {
        return departmentrepository.findAllDeptByDeptName(name);
    }

    @Override
    public List<Dept> findCustom() {
        return departmentrepository.findAllCseDeptsWithAddressD();
    }

}
