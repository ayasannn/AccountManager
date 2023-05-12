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
		mailList = acr.findByMail(ac.getMail());
		return mailList;
	}
	
	public List<AccountsEntity> findAccount(Accounts ac){
		List<AccountsEntity> acList = new ArrayList<>();
		acList = acr.findByMailAndPassword(ac.getMail(), ac.getPassword());
		return acList;
		
	}
	
	public List<AccountsEntity> findMailAndBirth(Accounts ac) {
		List<AccountsEntity> mpList = new ArrayList<>();
		mpList = acr.findByMailAndBirth(ac.getMail(), ac.getBirth());
		return mpList;
	}
	 
	public void save(Accounts acc) {
		var aEnt = new AccountsEntity();
		aEnt.setMail(acc.getMail());
		aEnt.setBirth(acc.getBirth());
		aEnt.setPassword(acc.getPassword());
		acr.save(aEnt);
	}
	
	public void updatePass(Accounts acc, List<AccountsEntity> aeList) {
		var acEnt = new AccountsEntity();
		acEnt.setId(aeList.get(0).getId());
		acEnt.setMail(aeList.get(0).getMail());
		acEnt.setBirth(aeList.get(0).getBirth());
		acEnt.setPassword(acc.getPassword());
		acr.save(acEnt);
	}
}