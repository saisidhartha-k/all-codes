package com.practice.springg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springg.dto.TeacherDepartmentDTO;
import com.practice.springg.entity.Dept;
import com.practice.springg.entity.Student;
import com.practice.springg.entity.Teacher;
import com.practice.springg.entity.TeacherDept;
import com.practice.springg.service.deptService;
import com.practice.springg.service.studentService;
import com.practice.springg.service.teacherDeptService;
import com.practice.springg.service.teacherService;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class springgRestController {

    @Autowired
    private deptService deptservice;

    @Autowired
    private teacherService teacherservice;

    @Autowired
    private studentService studentservice;

    @Autowired
    private teacherDeptService teacherDeptsDeptService;

    @GetMapping("/test")
    public String Check() {
        return "working";
    }

    @PostMapping("/addDept")
    public ResponseEntity<Dept> addDept(@RequestBody Dept dept) {
        System.out.println("Received Dept object: " + dept);
        return new ResponseEntity<>(deptservice.createDept(dept), HttpStatus.CREATED);

    }

    @GetMapping("/getDepts")
    public List<Dept> getDepts() {
        return deptservice.getDepts(null);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDept(@PathVariable int id) {
        deptservice.delete(id);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public Dept updateDept(@PathVariable int id, @RequestBody Dept dept) {
        
        return deptservice.update(id,dept);
    }

    @GetMapping("/findName/{name}")
    public List<Dept> getName(@PathVariable ("name")String name)
    {
        return deptservice.findname(name);
    }

    @GetMapping("/custom")
    public List<Dept> getCustom()
    {
        System.out.println("working");
        return deptservice.findCustom();
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher)
    {
        return teacherservice.addTeacher(teacher);
    }

    @GetMapping("/getTeacher")
    public List<Teacher> getTeachers()
    {
        return teacherservice.getTeachers();
    }

    @GetMapping("/getTeacher/Dept/{name}")
    public List<Teacher> getByDeptName(@PathVariable String name) {
        return teacherservice.getTeacherDepts(name);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student)
    {
        return studentservice.addStudent(student);
    }

    @PostMapping("/addData")
    public TeacherDept addDept(@RequestBody TeacherDept teacherDept)
    {
        return teacherDeptsDeptService.addData(teacherDept);
    }

    @GetMapping("/getDtos")
    public List<TeacherDepartmentDTO> gTeacherDepartmentDTOs()
    {
        return teacherDeptsDeptService.gDepartmentDTOs();
    }
}
