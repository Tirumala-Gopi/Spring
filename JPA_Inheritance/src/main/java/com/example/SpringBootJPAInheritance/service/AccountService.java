package com.example.SpringBootJPAInheritance.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.SpringBootJPAInheritance.model.Account;
import com.example.SpringBootJPAInheritance.model.AccountDto;
import com.example.SpringBootJPAInheritance.model.CheckingAccount;
import com.example.SpringBootJPAInheritance.model.SavingsAccount;
import com.example.SpringBootJPAInheritance.repository.AccountRepository;

@Service

public class AccountService {

	private AccountRepository accountRepo;

	public AccountService(AccountRepository accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}
	
	public Account addAccount (AccountDto accountDto) {
		Account account=null;
		if(accountDto.getAccountType().equals("Savings")) {
			account= new SavingsAccount();
		}
		
		else if(accountDto.getAccountType().equals("Checkings")) {
			account=new CheckingAccount();
		}
		
		BeanUtils.copyProperties(accountDto, account);
		return accountRepo.save(account);
		
	}

	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}

	public List<Account> getAllSavingsAccounts(){
		return accountRepo.findAllSavingsAccounts();
	}
	
	public void updateMinBalance(double minBalance,int id) {
		accountRepo.updateMinBalance(minBalance, id);
	}
}
