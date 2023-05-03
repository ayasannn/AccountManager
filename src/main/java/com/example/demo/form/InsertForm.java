package com.example.demo.form;

import lombok.Data;

@Data
public class InsertForm {

	@MailValid
	private String mail;
	
	@Password
	private String pass;
}
