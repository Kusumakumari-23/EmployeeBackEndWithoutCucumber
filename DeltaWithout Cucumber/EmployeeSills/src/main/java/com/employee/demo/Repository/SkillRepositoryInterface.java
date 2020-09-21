package com.employee.demo.Repository;

import java.util.List;

import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;

public interface SkillRepositoryInterface {

	public List<Skill> getAllSkills();
	Skill findSkillById(Long skillId);
	Skill updateSkillDetails(Skill skill);
    void deleteSkillDetails(Long skillId);
	
	
	public int[] batchSkillInsert(List<Skill> skills);
}
