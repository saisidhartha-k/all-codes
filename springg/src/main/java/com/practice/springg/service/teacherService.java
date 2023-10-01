package com.practice.springg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springg.entity.Teacher;
import com.practice.springg.repository.departmentRepository;
import com.practice.springg.repository.teacherRepo;

@Service
public class teacherService {

    @Autowired
    private teacherRepo teacherrepo;

    @Autowired departmentRepository departmentrepository;

    public Teacher addTeacher(Teacher teacher)
    {
        return teacherrepo.save(teacher);
    }

    public List<Teacher> getTeachers()
    {
        return teacherrepo.findAll();
    }

    public List<Teacher> getTeacherDepts(String name)
    {
        int id = departmentrepository.findByDeptName(name).getId();
        return null;
    }
    
}
