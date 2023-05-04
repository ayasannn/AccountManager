package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("NewMembers")
	public String loginView(@Validated InsertForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		return "submitted";
	}

}
