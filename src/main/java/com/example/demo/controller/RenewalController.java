package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RenewalForm;
import com.example.demo.repository.Accounts;
import com.example.demo.repository.AccountsServices;

@Controller
public class RenewalController {

	@Autowired
	AccountsServices acs;
	Accounts acc;
	
	@ModelAttribute
	public RenewalForm rnForm() {
		return new RenewalForm();
	}
	
	@PostMapping("renewal")
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
			return "mismatchmb";
		} else {
			
		return "finalanswer";
		}
	}
	
	@PostMapping("finalanswer")
	public String finalanswerView() {
		return "resetcomplete";
	}
	
	@PostMapping("resetcomplete")
	public String resetView() {
		acs.updatePass(acc, acs.findMailAndBirth(acc));
		return "resetcomplete";
	}
}
