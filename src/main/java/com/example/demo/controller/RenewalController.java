package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RenewalForm;
import com.example.demo.repository.Accounts;
import com.example.demo.repository.AccountsServices;

public class RenewalController {

	@Autowired
	AccountsServices acs;
	Accounts acc;
	
	@ModelAttribute
	public RenewalForm rnForm() {
		return new RenewalForm();
	}
	
	@GetMapping("renewal")
	public String showView() {
		return "renewal";
	}
	
	@PostMapping("remakepass")
	public String loginView(@Validated RenewalForm rnForm, BindingResult bdr) {
		if (bdr.hasErrors())
			return "renewal";
		
		//バリデーションのエラーがなかった時
		acc = new Accounts();
		acc.setMail(rnForm.getMail());
		acc.setBirth(rnForm.getBirth());
		acc.setPassword(rnForm.getPass());
		//空っぽの時＝メールと誕生日不一致
		if(acs.findMailAndBirth(acc).isEmpty()) {
			return "renewal";
		} else {
			
		return "finalanswer";
		}
	}
	
	@PostMapping("finalanswer")
	public String finalanswerView() {
		acs.save(acc);
		return "resetcomplete";
	}
}
