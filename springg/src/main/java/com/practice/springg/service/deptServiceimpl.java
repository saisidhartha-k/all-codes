package com.practice.springg.service;

import java.util.List;

import com.practice.springg.entity.Dept;

public interface deptServiceimpl {
    Dept createDept(Dept dept);

    List<Dept> getDepts(Dept dept);

    void delete(int id);

    Dept update(int id,Dept dept);

    List<Dept> findname(String name);

    List<Dept> findCustom();
}
