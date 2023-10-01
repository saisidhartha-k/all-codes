package com.practice.springg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.springg.entity.Teacher;

@Repository
public interface teacherRepo extends JpaRepository<Teacher, Integer> {
    // @Query("SELECT t FROM Teacher t JOIN t.departmentIds d WHERE d = :deptId")
    // List<Teacher> findTeachersByDeptId(@Param("deptId") int deptId);
    
}
