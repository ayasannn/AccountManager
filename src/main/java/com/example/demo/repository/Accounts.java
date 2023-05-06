package com.example.demo.repository;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
	
	@Id
	private Integer id;
	private String mail;
	private Date birth;
	private String password;
	
}
