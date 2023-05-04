package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.InsertForm;
import com.example.demo.validator.MultiValidator;

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
	
	@PostMapping("home")
	public String loginView(@Validated InsertForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "login";
		}
		return "home";
	}
	
	@Autowired
	MultiValidator mv;
	@InitBinder("insertForm")
	public void initBinder(WebDataBinder wdb) {
		wdb.addValidators(mv);
	}
}


