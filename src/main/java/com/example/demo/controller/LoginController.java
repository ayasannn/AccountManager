package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.InsertForm;
import com.example.demo.repository.Accounts;
import com.example.demo.repository.AccountsServices;

@Controller
public class LoginController {

	@Autowired
	AccountsServices acs;

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
			System.out.println("バリデーションではじかれました。");
			return "login";
		}
		var acc = new Accounts();
		acc.setMail(form.getMail());
		acc.setPassword(form.getPass());
		System.out.println("バリデーションOK!");
		if(acs.findAccount(acc).isEmpty()) {
			return "mistaken";
		}else {
			return "home";
		}
	}
}


