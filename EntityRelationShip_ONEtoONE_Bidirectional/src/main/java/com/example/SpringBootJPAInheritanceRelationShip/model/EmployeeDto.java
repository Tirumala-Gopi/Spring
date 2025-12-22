package com.example.SpringBootJPAInheritanceRelationShip.model;

public class EmployeeDto {

	private String empName;
	private double salary;
	private String specialization;
	private String deskno;
	private String employeeType;
	private PayRoll payRoll;
	
	public EmployeeDto(String empName, double salary, String specialization, String deskno, String employeeType,PayRoll payroll) {
		super();
		this.empName = empName;
		this.salary = salary;
		this.specialization = specialization;
		this.deskno = deskno;
		this.employeeType = employeeType;
		this.payRoll=payroll;
	}
	
	public PayRoll getPayRoll() {
		return payRoll;
	}

	public void setPayRoll(PayRoll payroll) {
		this.payRoll = payroll;
	}

	public EmployeeDto() {
		super();
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDeskno() {
		return deskno;
	}
	public void setDeskno(String deskno) {
		this.deskno = deskno;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empName=" + empName + ", salary=" + salary + ", specialization=" + specialization
				+ ", deskno=" + deskno + ", employeeType=" + employeeType + ", payroll=" + payRoll + "]";
	}
	
	
}
