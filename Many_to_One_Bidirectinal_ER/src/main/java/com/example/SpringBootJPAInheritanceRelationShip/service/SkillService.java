package com.example.SpringBootJPAInheritanceRelationShip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootJPAInheritanceRelationShip.model.Skill;
import com.example.SpringBootJPAInheritanceRelationShip.repository.SkillRepository;

@Service

public class SkillService {

	private SkillRepository skillRepo;

	public SkillService(SkillRepository skillRepo) {
		super();
		this.skillRepo = skillRepo;
	}
	
	public Skill addSkill(Skill skill) {
		return skillRepo.save(skill);
	}
	
	public List<Skill> findAllSkills(){
		return skillRepo.findAll();
	}
	
	public Skill findSkillById(long id) {
		return skillRepo.findById(id).get();
		
	}
}
