package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RegisterForm;
import com.example.demo.repository.Accounts;
import com.example.demo.repository.AccountsServices;

@Controller
public class RegisterController {
	
	@Autowired
	AccountsServices acs;
	Accounts acc;
	
	@ModelAttribute
	public RegisterForm rFrom() {
		return new RegisterForm();
	}
	
	@GetMapping("register")
	public String registerView() {
		return "register";
	}
	
	@PostMapping("newmember")
	public String loginView(@Validated RegisterForm rForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("バリデーション通ってる。");
			return "register";
		}
//		model 処理→DBで過去に登録されていないことを確認
//		NG→select mail from accounts →　１件以上
//		→registerに戻る。
		
		acc = new Accounts();
		acc.setMail(rForm.getMail());
		acc.setBirth(rForm.getBirth());
		acc.setPassword(rForm.getPass());
//		List<AccountsEntity> lst = acs.findByMail( rForm.getMail()) ;	この書き方でも◎
		System.out.println("アカウント承認を通ってる");
		if (!acs.serch(acc).isEmpty()) {
			System.out.println("からっぽじゃない");
			acs.serch(acc).forEach(System.out::print);
			return "already";
		} else {
			System.out.println("からっぽの時");

			return "check";
		}
	}
	
	@PostMapping("check")
	public String confirmView() {
		return "submit";
	}
	
	@PostMapping("submitted")
	public String submittedView() {
		acs.save(acc);
		return "submitted";
	}
}
