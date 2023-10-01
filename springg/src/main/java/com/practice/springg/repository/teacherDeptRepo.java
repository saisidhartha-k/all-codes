package com.practice.springg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.springg.dto.TeacherDepartmentDTO;
import com.practice.springg.entity.TeacherDept;

@Repository
public interface teacherDeptRepo extends JpaRepository<TeacherDept, Integer> {
    @Query("SELECT NEW com.practice.springg.dto.TeacherDepartmentDTO(t.name AS teacherName, td.department.deptName AS departmentName) FROM TeacherDept td INNER JOIN td.teacher t")

    List<TeacherDepartmentDTO> findAllTeacherAndDeptNames();
}
