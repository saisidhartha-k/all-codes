package com.practice.springg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TeacherDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept department;
    

}
