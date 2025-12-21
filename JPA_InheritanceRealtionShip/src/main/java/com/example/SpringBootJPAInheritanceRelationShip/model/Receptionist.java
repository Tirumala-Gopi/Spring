package com.example.SpringBootJPAInheritanceRelationShip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Receptionist_joined")
public class Receptionist extends Employee {


	private String deskno;
	public Receptionist(String empName, double salary) {
		super(empName, salary);
		// TODO Auto-generated constructor stub
	}


	public Receptionist() {
		super();
	}


	public Receptionist(String empName, double salary, String deskno) {
		super(empName, salary);
		this.deskno = deskno;
	}



	
}
