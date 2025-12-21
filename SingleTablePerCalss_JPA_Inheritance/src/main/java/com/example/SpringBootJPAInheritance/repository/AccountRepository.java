package com.example.SpringBootJPAInheritance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootJPAInheritance.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("select s from SavingsAccount s")
	List<Account> findAllSavingsAccounts();
	
	@Transactional
	@Modifying
	@Query("update SavingsAccount s set s.minBalance = :minBalance where s.id= :id")
	void updateMinBalance(@Param("minBalance") double minBalance,@Param ("id")int id);
}
