package com.example.SpringBootJPAInheritanceRelationShip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJPAInheritanceRelationShip.model.Employee;
import com.example.SpringBootJPAInheritanceRelationShip.model.EmployeeDto;
import com.example.SpringBootJPAInheritanceRelationShip.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto empDto){
		
		Employee returnedEmployee= employeeService.addEmployee(empDto);
		return ResponseEntity.ok(returnedEmployee);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployeees(){
		return ResponseEntity.ok(employeeService.retrieveEmployees());
	}
	
	@GetMapping("/doctor/doctors")
	public ResponseEntity<List<Employee>> getAllDoctors(){
		return ResponseEntity.ok(employeeService.findAllDoctors());
	}
	
	
	
	
}
