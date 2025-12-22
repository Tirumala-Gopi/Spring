package com.example.SpringBootJPAInheritanceRelationShip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Docator_joined")
public class Doctor extends Employee {

	private String specialization;

	public Doctor(String empName, double salary, String specialization) {
		super(empName, salary);
		this.specialization = specialization;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [specialization=" + specialization + "]";
	}
	
	
}
