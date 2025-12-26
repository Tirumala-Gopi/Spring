package com.example.Account_and_customer_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Account_and_customer_management.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
