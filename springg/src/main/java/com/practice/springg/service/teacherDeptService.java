package com.practice.springg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springg.repository.teacherDeptRepo;
import com.practice.springg.dto.TeacherDepartmentDTO;
import com.practice.springg.entity.Dept;
import com.practice.springg.entity.Teacher;
import com.practice.springg.entity.TeacherDept;

@Service
public class teacherDeptService {

    @Autowired
    private teacherDeptRepo teacherDeptRepo;

    public TeacherDept addData(TeacherDept teacherDept)
    {
        return teacherDeptRepo.save(teacherDept);
    }

    public List<TeacherDepartmentDTO> gDepartmentDTOs()
    {
        return teacherDeptRepo.findAllTeacherAndDeptNames();
    }
    
}
