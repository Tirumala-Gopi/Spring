package com.example.SpringBootJPAInheritanceRelationShip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJPAInheritanceRelationShip.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
