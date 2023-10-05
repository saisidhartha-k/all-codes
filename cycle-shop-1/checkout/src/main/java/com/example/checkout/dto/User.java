package com.example.checkout.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String role;
    


	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public String getRole() {
		return this.role;
	}

}