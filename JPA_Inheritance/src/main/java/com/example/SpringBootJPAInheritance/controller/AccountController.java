package com.example.SpringBootJPAInheritance.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.SpringBootJPAInheritance.model.Account;
import com.example.SpringBootJPAInheritance.model.AccountDto;
import com.example.SpringBootJPAInheritance.service.AccountService;


@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto){
		
		Account createAccount=accountService.addAccount(accountDto);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createAccount.getId()).toUri();
		return ResponseEntity.created(location).body(createAccount);
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccount(){
		
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@GetMapping("/savings")
	public ResponseEntity<List<Account>> getAllSavingsAccount(){
		
		return ResponseEntity.ok(accountService.getAllSavingsAccounts());
	}
	
	@PutMapping("/updateMinBalance/{minBalance}/{id}")
	public void updateMinBalance(@PathVariable double minBalance,@PathVariable int id) {
		
		accountService.updateMinBalance(minBalance, id);
		
	}
	
	
	
	
	

}
