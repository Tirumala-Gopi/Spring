package com.example.SpringBootJPAInheritanceRelationShip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJPAInheritanceRelationShip.model.Skill;
import com.example.SpringBootJPAInheritanceRelationShip.service.SkillService;

@RestController
@RequestMapping("api/v1/skills")
public class SkillController {
	private SkillService skillService;

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping
	public ResponseEntity<Skill> addSkill(@RequestBody Skill skill){
		
		Skill returnSkill= skillService.addSkill(skill);
		return ResponseEntity.ok(returnSkill);
	}
	
	@GetMapping
	public List<Skill> getAllSkills(){
		return skillService.findAllSkills();
	}
	
	@GetMapping("/{id}")
	public Skill getSkillById(@PathVariable long id) {
		return skillService.findSkillById(id);
	}

}
