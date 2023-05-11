package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsCrudRepository extends CrudRepository<AccountsEntity, Integer> {
//	Iterable<AccountsEntity> findByName( String mail ) ;
	
	public List<AccountsEntity> findByMail(String mail);
	public List<AccountsEntity> findByMailAndBirth(String mail, Date birth);
	public List<AccountsEntity> findByMailAndPassword(String mail, String password);
	
}
