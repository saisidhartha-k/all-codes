package com.practice.springg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springg.entity.Student;
import com.practice.springg.repository.studentRepo;

@Service
public class studentService {
    @Autowired
    private studentRepo studentrepo;

    public Student addStudent(Student student)
    {
        return studentrepo.save(student);
    }
}
