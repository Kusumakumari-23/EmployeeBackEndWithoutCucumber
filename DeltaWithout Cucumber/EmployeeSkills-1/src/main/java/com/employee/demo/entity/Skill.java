package com.employee.demo.entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Entity
//@Table(name="skills", schema="employee")
@AllArgsConstructor
@Data
@IdClass(SkillCompositeKey.class)
public class Skill {
	
	@Id
	private Long skillId;
	
	@Id
	private String skillName;
	
//	@Column(name="details")
	private String details;

	@ManyToOne
	private Employee emp;
}
