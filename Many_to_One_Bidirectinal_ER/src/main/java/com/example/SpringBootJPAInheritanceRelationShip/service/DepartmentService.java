package com.example.SpringBootJPAInheritanceRelationShip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootJPAInheritanceRelationShip.model.Department;
import com.example.SpringBootJPAInheritanceRelationShip.repository.DepartmentRepository;

@Service

public class DepartmentService {

	private DepartmentRepository deptRepo;

	public DepartmentService(DepartmentRepository deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}
	public Department addDepartment(Department department) {
		return deptRepo.save(department);
	}
	
	public List<Department> findAll(){
		return deptRepo.findAll();
	}
	
	
}
