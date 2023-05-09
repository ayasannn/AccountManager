package com.example.demo.repository;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@jakarta.persistence.Table(name = "accounts")
public class AccountsEntity implements Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "birth")
	private Date birth;
	
	@Column(name = "password")
	private String password;
}
