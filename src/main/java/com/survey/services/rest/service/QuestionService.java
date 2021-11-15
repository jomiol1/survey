package com.survey.services.rest.service;

import java.util.List;

import com.survey.services.rest.dto.QuestionResponse;

public interface QuestionService {
	
	public List<QuestionResponse> getQuestions();

}
