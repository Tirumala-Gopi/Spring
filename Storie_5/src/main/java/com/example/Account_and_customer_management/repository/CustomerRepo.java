package com.example.Account_and_customer_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Account_and_customer_management.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query("select p from Person p")
	List<Customer> findAllPersons();

	
	@Query("SELECT c FROM Customer c JOIN c.address a WHERE a.city = 'Toronto'")
	List<Customer> findAllCustomers();

}
