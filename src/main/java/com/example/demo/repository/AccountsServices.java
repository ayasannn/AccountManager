package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountsServices {
	
	@Autowired
	AccountsCrudRepository acr;
	
	public List<AccountsEntity> serch(Accounts ac){
		List<AccountsEntity> mailList = new ArrayList<>();
		var aEnt = new AccountsEntity();
		aEnt.setMail(ac.getMail());
		mailList = acr.findByMail(aEnt.getMail());
		return mailList;
	}
	
	public void save(Accounts acc) {
		var aEnt = new AccountsEntity();
		aEnt.setMail(acc.getMail());
		aEnt.setBirth(acc.getBirth());
		aEnt.setPassword(acc.getPassword());
		acr.save(aEnt);
	}
}