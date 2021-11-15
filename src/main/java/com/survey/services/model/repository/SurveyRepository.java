package com.survey.services.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.services.model.entity.SurveyEntity;

@Repository
public interface SurveyRepository extends CrudRepository<SurveyEntity, Long>{
	
	  public List<SurveyEntity> findAll();

}
