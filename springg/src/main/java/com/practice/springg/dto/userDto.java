package com.practice.springg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class userDto {
    private String name;
    private String password;
    private String rePassWord;
}
