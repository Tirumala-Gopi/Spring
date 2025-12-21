package com.example.SpringBootJPAInheritanceRelationShip.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.SpringBootJPAInheritanceRelationShip.model.Doctor;
import com.example.SpringBootJPAInheritanceRelationShip.model.Employee;
import com.example.SpringBootJPAInheritanceRelationShip.model.EmployeeDto;
import com.example.SpringBootJPAInheritanceRelationShip.model.Receptionist;
import com.example.SpringBootJPAInheritanceRelationShip.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee (EmployeeDto employeeDto) {
		Employee employee=null;
		if(employeeDto.getEmployeeType().equals("doctor")) {
			employee= new Doctor();
		}
		
		else if(employeeDto.getEmployeeType().equals("receptionist")) {
			employee=new Receptionist();
		}
		
		BeanUtils.copyProperties(employeeDto, employee);
		return employeeRepo.save(employee);
		
	}

	public List<Employee> retrieveEmployees(){
		return employeeRepo.findAll();
	}
	
	public List<Employee> findAllDoctors(){
		return employeeRepo.findAllDoctors();
		
	}
	
	
}
