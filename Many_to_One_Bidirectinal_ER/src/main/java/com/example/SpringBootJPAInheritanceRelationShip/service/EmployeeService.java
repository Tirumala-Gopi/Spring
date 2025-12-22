package com.example.SpringBootJPAInheritanceRelationShip.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.SpringBootJPAInheritanceRelationShip.model.Department;
import com.example.SpringBootJPAInheritanceRelationShip.model.Doctor;
import com.example.SpringBootJPAInheritanceRelationShip.model.Employee;
import com.example.SpringBootJPAInheritanceRelationShip.model.EmployeeDto;
import com.example.SpringBootJPAInheritanceRelationShip.model.PayRoll;
import com.example.SpringBootJPAInheritanceRelationShip.model.Receptionist;
import com.example.SpringBootJPAInheritanceRelationShip.model.Skill;
import com.example.SpringBootJPAInheritanceRelationShip.repository.DepartmentRepository;
import com.example.SpringBootJPAInheritanceRelationShip.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepo;
	private DepartmentRepository deptRepo;
	private SkillService skillService;
	
	
	

	public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository deptRepo, SkillService skillService) {
		super();
		this.employeeRepo = employeeRepo;
		this.deptRepo = deptRepo;
		this.skillService = skillService;
	}

	public Employee addEmployee (EmployeeDto employeeDto) {
		Employee employee=null;
		if(employeeDto.getEmployeeType().equals("doctor")) {
			employee= new Doctor();
		}
		
		else if(employeeDto.getEmployeeType().equals("receptionist")) {
			employee=new Receptionist();
		}
		
		BeanUtils.copyProperties(employeeDto, employee);
		PayRoll payRoll = employee.getPayRoll();

	    if (payRoll != null) {
	        payRoll.setEmployee(employee); 
	        employee.setPayRoll(payRoll);
	    }
		//employee.getPayRoll().setEmployee(employee);
		return employeeRepo.save(employee);
		
	}

	public List<Employee> retrieveEmployees(){
		return employeeRepo.findAll();
	}
	
	public List<Employee> findAllDoctors(){
		return employeeRepo.findAllDoctors();
		
	}
	
	public void setEmployee(long employeeId,long departmentId) {
		Employee employeeReceived= retrieveEmployeeById(employeeId);
		Department departmentReceived=deptRepo.findById(departmentId).get();
	
		employeeReceived.setDepartment(departmentReceived);
		departmentReceived.getEmployees().add(employeeReceived);
		employeeRepo.save(employeeReceived);
	}

	public Employee retrieveEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));
	}
	
	public void setSkill(long employeeId,long SkillId) {
		Employee employeeReceived= retrieveEmployeeById(employeeId);
		Skill skillReceived=skillService.findSkillById(SkillId);
		employeeReceived.getSkills().add(skillReceived);
		skillReceived.getEmployees().add(employeeReceived);
		employeeRepo.save(employeeReceived);
	}
	
}
