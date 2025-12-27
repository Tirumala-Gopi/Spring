package com.example.Account_and_customer_management.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Account_and_customer_management.model.Account;
import com.example.Account_and_customer_management.model.AccountDto;
import com.example.Account_and_customer_management.model.Address;
import com.example.Account_and_customer_management.model.CheckingAccount;
import com.example.Account_and_customer_management.model.Company;
import com.example.Account_and_customer_management.model.Customer;
import com.example.Account_and_customer_management.model.CustomerDto;
import com.example.Account_and_customer_management.model.GeoResponseDto;
import com.example.Account_and_customer_management.model.Person;
import com.example.Account_and_customer_management.model.SavingsAccount;
import com.example.Account_and_customer_management.repository.AccountRepository;
import com.example.Account_and_customer_management.repository.CustomerRepo;

@Service
public class CustomerService {
	private final CustomerRepo custRepo;
	private final WebClient webClient;
	private final AccountRepository accountRepo;

	

	public CustomerService(CustomerRepo custRepo, WebClient webClient, AccountRepository accountRepo) {
		super();
		this.custRepo = custRepo;
		this.webClient = webClient;
		this.accountRepo = accountRepo;
	}




	public Customer addCustomer(CustomerDto dto) {

		GeoResponseDto geoResponse = webClient.get()
				.uri(uriBuilder -> uriBuilder.queryParam("Postal", dto.getPostalCode()).queryParam("json", 1).build())
				.retrieve().bodyToMono(GeoResponseDto.class).block();

		if (geoResponse == null) {
			throw new RuntimeException("Unable to fetch location details");
		}
		
		Address address = new Address();
		address.setStreetNumber(dto.getStreetNumber());
		address.setPostalCode(dto.getPostalCode());

		Customer customer = null;
		if(dto.getCustomerType().equals("person")) {
			customer=new Person(dto.getName(),address);
		}
		else if(dto.getCustomerType().equals("company")) {
			customer=new Company();
		}
		
		Account account=null;
			if(dto.getAccountType().equals("savings")) {
				account=new SavingsAccount(dto.getInterestRate());
				
				
			}
			else if(dto.getAccountType().equals("checkings")) {
				account=new CheckingAccount(dto.getNextCheckNumber());
			}
		
		account.setBalance(dto.getBalance());
		account.setCustomer(customer);
		customer.setName(dto.getName());
		address.setCustomer(customer);

	
		if (geoResponse != null) {
		    address.setCity(geoResponse.getStandard().getCity());
		    address.setProvince(geoResponse.getStandard().getProv());
		}

		
		customer.setAddress(address);
		customer.getAccounts().add(account);
		
		
		//System.out.println(customer);
		return custRepo.save(customer);
	}
	
	public void addAccount(AccountDto accDto,long id) {
		
		Account account=null;
		if(accDto.getAccountType().equals("savings")) {
			account=new SavingsAccount(accDto.getInterestRate());
			
			
		}
		else if(accDto.getAccountType().equals("checkings")) {
			account=new CheckingAccount(accDto.getNextCheckNumber());
		}
		account.setBalance(accDto.getBalance());
		//System.out.println(account);
		custRepo.findById(id).get().getAccounts().add(account);
		account.setCustomer(custRepo.findById(id).get());
		//custRepo.save(custRepo.findById(id).get());
		accountRepo.save(account);
		
	}
	
	
	

	public List<Customer> getAllCustomers() {

		return custRepo.findAll();
	}

	public Customer findCustomer(long id) {

		return custRepo.findById(id).get();
	}

	public List<Customer> findAllPersons() {
		
		return custRepo.findAllPersons();
	}

	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}




	public List<Customer> findAllCustomers() {
		
		return custRepo.findAllCustomers();
	}

}
