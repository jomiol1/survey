package com.survey.services.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.services.model.entity.QuestionEntity;
import com.survey.services.model.repository.QuestionRepository;
import com.survey.services.rest.dto.QuestionResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;
import com.survey.services.rest.service.QuestionService;

@Service
public class QuestionServiceImplement implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<QuestionResponse> getQuestions() {
		List<QuestionEntity> questions = questionRepository.findAll();
		
		List<QuestionResponse> questionsResponse = new ArrayList<>();
		
		questions.forEach(question->{
			List<SurveyGenericResponse> answers = new ArrayList<>();
			question.getQuestionAnsweId().forEach(answer->
				answers.add(new SurveyGenericResponse(answer.getAnswerId().getId(),answer.getAnswerId().getAnswer()))
			);
			
			questionsResponse.add(new QuestionResponse(question.getId(), question.getQuestion(), answers));
		});
	    
	    
		return questionsResponse;
	}

}
