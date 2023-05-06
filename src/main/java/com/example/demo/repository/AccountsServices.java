package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountsServices {
	
	@Autowired
	AccountsCrudRepository acr;
	
//	//新規会員登録用
//	private void executeInsert(String mail, Date birth, String pass) {
//		Accounts ac = new Accounts(null, mail, birth, pass);
//		ac = acr.save(ac);
//	}
}