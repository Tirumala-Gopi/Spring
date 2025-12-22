package com.example.SpringBootJPAInheritanceRelationShip.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//property= "id")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DEPARTMENT_SEQ_GEN")
	@SequenceGenerator(name = "DEPARTMENT_SEQ_GEN" ,sequenceName="DEPARTMENT_SEQ" )
	private int id;
	private String name;
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employees;
	public Department() {
		super();
	}
	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
	
	
	
}
