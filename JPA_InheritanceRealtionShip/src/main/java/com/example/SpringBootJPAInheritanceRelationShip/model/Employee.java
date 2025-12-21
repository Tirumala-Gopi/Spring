package com.example.SpringBootJPAInheritanceRelationShip.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Employee_joined")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EMPLOYEE_SEQ_GEN")
	@SequenceGenerator(name = "EMPLOYEE_SEQ_GEN" ,sequenceName="EMPLOYEE_SEQ" )
	private int id;
	private String empName;
	private double salary;
	public Employee(int id, String empName, double salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.salary = salary;
	}
	public Employee(String empName, double salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empName, id, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empName, other.empName) && id == other.id
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	
	
	
}
