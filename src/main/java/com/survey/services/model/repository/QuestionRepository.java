package com.survey.services.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.services.model.entity.QuestionEntity;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Long>{

	  public List<QuestionEntity> findAll();
}
