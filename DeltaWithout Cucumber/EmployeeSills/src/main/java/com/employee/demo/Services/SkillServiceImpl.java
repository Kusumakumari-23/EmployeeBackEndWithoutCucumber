package com.employee.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.Repository.SkillRepositoryInterface;
import com.employee.demo.entity.Skill;

@Service
public class SkillServiceImpl implements SkillServiceInterface {

	@Autowired
	private SkillRepositoryInterface skillRepo;
	
	@Override
	public List<Skill> getAllSkills() {
		
		return skillRepo.getAllSkills();
	}
	
	public Skill findSkillById(Long skillId) {
		
		return skillRepo.findSkillById(skillId);
	}
	
	@Override
    public int[] batchSkillInsert(List<Skill> skills) {
	
	return skillRepo.batchSkillInsert(skills);
}

	@Override
	public Skill updateSkillDetails(Skill skill) {
		
		return skillRepo.updateSkillDetails(skill);
	}

	@Override
	public void deleteSkillDetails(Long skillId) {
		
	    skillRepo.deleteSkillDetails(skillId);
		
	}
}
