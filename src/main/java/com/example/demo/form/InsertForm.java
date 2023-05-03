package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InsertForm {

//	@MailValid
	@NotBlank
	private String mail;
	
//	@Password
	@NotBlank
	@NotNull
	private String pass;
}
