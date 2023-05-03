package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.InsertForm;

@Controller
public class RegisterController {
	
	@ModelAttribute
	public InsertForm from() {
		return new InsertForm();
	}
	
	@GetMapping("register")
	public String registerView() {
		return "register";
	}

}
