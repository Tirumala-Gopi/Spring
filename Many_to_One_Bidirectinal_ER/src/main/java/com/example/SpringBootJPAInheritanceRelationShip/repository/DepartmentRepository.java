package com.example.SpringBootJPAInheritanceRelationShip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJPAInheritanceRelationShip.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
