package com.example.Account_and_customer_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Customer> create(@RequestBody CustomerDto customer) {
		Customer created = custService.addCustomer(customer);

		return ResponseEntity.ok(created);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return custService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable long id) {
		return custService.findCustomer(id);
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Customer>> findAllPersons(){
	
	return ResponseEntity.ok(custService.findAllPersons());
	
			}

}
