package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.InsertForm;

@Controller
public class RegisterController {
	
	
	@ModelAttribute
	public InsertForm from() {
		return new InsertForm();
	}
	
	@RequestMapping("/css")
	public String withCssView(Model model) {
		return "css";
	}
	
	@GetMapping("register")
	public String registerView() {
		return "register";
	}
	
	@PostMapping("newmember")
	public String loginView(@Validated InsertForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		return "submitted";
	}

}
