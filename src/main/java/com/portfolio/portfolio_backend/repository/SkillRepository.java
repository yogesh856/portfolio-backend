package com.portfolio.portfolio_backend.repository;

import com.portfolio.portfolio_backend.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
}
