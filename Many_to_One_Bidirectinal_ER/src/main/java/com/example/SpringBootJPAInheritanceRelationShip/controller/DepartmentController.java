package com.example.SpringBootJPAInheritanceRelationShip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJPAInheritanceRelationShip.model.Department;
import com.example.SpringBootJPAInheritanceRelationShip.service.DepartmentService;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

	private DepartmentService deptService;

	public DepartmentController(DepartmentService deptService) {
		super();
		this.deptService = deptService;
	}
	
	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		
		Department returnDepartment=deptService.addDepartment(department);
		return ResponseEntity.ok(returnDepartment);
	}
	
	@GetMapping
	public List<Department> getAllDepts(){
		return deptService.findAll();
	}
	
}
