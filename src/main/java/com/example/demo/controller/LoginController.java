package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.InsertForm;

@Controller
public class LoginController {
	@ModelAttribute
	public InsertForm setUpForm() {
		return new InsertForm();
	}
	@GetMapping("AccountManager")
	public String showView() {
		return "login";
	}
	@PostMapping("AccountManager")
	public String loginView(@Validated InsertForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "login";
		}
		return "home";
	}
}
