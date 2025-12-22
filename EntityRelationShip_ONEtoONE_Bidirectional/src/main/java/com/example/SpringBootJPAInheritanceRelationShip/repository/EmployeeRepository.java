package com.example.SpringBootJPAInheritanceRelationShip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SpringBootJPAInheritanceRelationShip.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select d from Doctor d")
	List<Employee> findAllDoctors();

}
