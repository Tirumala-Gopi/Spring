package com.example.Account_and_customer_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.Account_and_customer_management.model.Customer;
import com.example.Account_and_customer_management.model.CustomerDto;
import com.example.Account_and_customer_management.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository custRepo;

	public CustomerService(CustomerRepository custRepo) {
		super();
		this.custRepo = custRepo;
	}

	public Customer addCustomer( CustomerDto customer) {
		Customer cust=new Customer();
		BeanUtils.copyProperties(customer, cust);
		return custRepo.save(cust);
	}

	public Customer getById(long id) {
		
		return custRepo.findById(id).get();
	}

	public void update(CustomerDto customerDto,long id) {
		//Optional<Customer> cust=custRepo.findById(id);
		Customer cust=custRepo.findById(id).get();
		System.out.println(cust);
		System.out.println(customerDto);
			if(cust!= null) {
			BeanUtils.copyProperties(customerDto, cust);
			custRepo.save(cust);		}
			
		
	}

	public void deleteById(long id) {
		custRepo.deleteById(id);
		
	}
	public List<Customer> getAll(){
		
		return custRepo.findAll();
	}
}
