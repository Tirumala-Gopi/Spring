package com.example.SpringBootJPAInheritanceRelationShip.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property= "payrollNo")
public class PayRoll {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PAYROLL_SEQ_GEN")
	@SequenceGenerator(name = "PAYROLL_SEQ_GEN" ,sequenceName="PAYROLL_SEQ" )
	private int payrollNo;
	private float hourlyRate;
	
	@OneToOne(mappedBy="payRoll")
	//@JsonBackReference
	private Employee employee;
	public PayRoll(int payrollNo, float hourlyRate, Employee employee) {
		super();
		this.payrollNo = payrollNo;
		this.hourlyRate = hourlyRate;
		this.employee = employee;
	}

	public PayRoll() {
		super();
	}

	public PayRoll(float hourlyRate, Employee employee) {
		super();
		this.hourlyRate = hourlyRate;
		this.employee = employee;
	}

	public int getPayrollNo() {
		return payrollNo;
	}

	public void setPayrollNo(int payrollNo) {
		this.payrollNo = payrollNo;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PayRoll [payrollNo=" + payrollNo + ", hourlyRate=" + hourlyRate + ", employee=" + employee + "]";
	}
	
	
}
