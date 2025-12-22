package com.example.SpringBootJPAInheritanceRelationShip.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SKILL_SEQ_GEN")
	@SequenceGenerator(name = "SKILL_SEQ_GEN" ,sequenceName="SKILL_SEQ" )
	private int id;
	private String technology;
	
	@ManyToMany(mappedBy="skills")
	private List<Employee> employees;

	public Skill() {
		super();
	}

	public Skill(String technology, List<Employee> employees) {
		super();
		this.technology = technology;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", technology=" + technology + ", employees=" + employees + "]";
	}
	
	
}
