package com.example.Account_and_customer_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Account_and_customer_management.model.Customer;
import com.example.Account_and_customer_management.model.CustomerDto;
import com.example.Account_and_customer_management.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	private CustomerService custService;

	public CustomerController(CustomerService custService) {
		super();
		this.custService = custService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
		
		
		Customer created=custService.addCustomer(customerDto);
		
		return ResponseEntity.ok(created);
		
		
	}
	
	@GetMapping("/{id}")
	public Customer findById(@PathVariable long id) {
		return custService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable long id) {
		custService.update(customerDto,id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		custService.deleteById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		return ResponseEntity.ok(custService.getAll());
	}
	
	
}
