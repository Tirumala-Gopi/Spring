package com.example.Account_and_customer_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Account_and_customer_management.model.Address;
import com.example.Account_and_customer_management.model.Customer;
import com.example.Account_and_customer_management.model.CustomerDto;
import com.example.Account_and_customer_management.model.GeoResponseDto;
import com.example.Account_and_customer_management.repository.CustomerRepo;

@Service
public class CustomerService {
	private final CustomerRepo custRepo;
	private final WebClient webClient;

	public CustomerService(CustomerRepo custRepo, WebClient webClient) {
		super();
		this.custRepo = custRepo;
		this.webClient = webClient;
	}

	public Customer addCustomer(CustomerDto dto) {

		GeoResponseDto geoResponse = webClient.get()
				.uri(uriBuilder -> uriBuilder.queryParam("Postal", dto.getPostalCode()).queryParam("json", 1).build())
				.retrieve().bodyToMono(GeoResponseDto.class).block();

		if (geoResponse == null) {
			throw new RuntimeException("Unable to fetch location details");
		}

		Customer customer = new Customer();
		customer.setName(dto.getName());
		Address address = new Address();
		address.setStreetNumber(dto.getStreetNumber());
		address.setPostalCode(dto.getPostalCode());

	
		if (geoResponse != null) {
		    address.setCity(geoResponse.getStandard().getCity());
		    address.setProvince(geoResponse.getStandard().getProv());
		}

		
		customer.setAddress(address);

		return custRepo.save(customer);
	}

	public List<Customer> getAllCustomers() {

		return custRepo.findAll();
	}

	public Customer findCustomer(long id) {

		return custRepo.findById(id).get();
	}

}
