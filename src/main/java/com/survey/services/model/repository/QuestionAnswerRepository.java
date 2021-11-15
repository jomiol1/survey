package com.survey.services.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.services.model.entity.QuestionAnswerEntity;

@Repository
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswerEntity, Long>{

}
