package com.example.demo.repository;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Accounts implements Serializable{
	
	private String mail;
	
	private Date birth;
	
	private String password;
	
}
