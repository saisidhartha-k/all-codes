package com.user.test2.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Dept {
    private int id;
    private String name;
    private List<Employee> employee = new ArrayList<>();
}
