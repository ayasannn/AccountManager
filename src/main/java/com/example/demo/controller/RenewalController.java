package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.RenewalForm;
import com.example.demo.repository.AccountsServices;

public class RenewalController {

	@Autowired
	AccountsServices acs;
	
	@ModelAttribute
	public RenewalForm setUpForm() {
		return new RenewalForm();
	}
	
	@GetMapping("renewal")
	public String showView() {
		return "renewal";
	}
	
	
}
