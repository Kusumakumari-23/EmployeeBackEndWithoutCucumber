package com.employee.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Table(name="employees",schema="employee")
@AllArgsConstructor
@Data
@IdClass(EmployeeCompositeKey.class)
public class Employee {

	@Id
	private Long empId;
	
	@Id
	private String firstName;
	
	private String lastName;
	
	private Date hireDate;
	
	private String city;
	
	private String email;
	
	private String phoneNum;
	
	@OneToMany
	private List<Skill> skills;
	
	
}
