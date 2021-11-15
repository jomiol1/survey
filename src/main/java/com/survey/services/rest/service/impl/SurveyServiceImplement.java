package com.survey.services.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.services.mapper.SurveyMapper;
import com.survey.services.model.entity.AnswerEntity;
import com.survey.services.model.entity.QuestionEntity;
import com.survey.services.model.entity.SurveyAnswerEntity;
import com.survey.services.model.entity.SurveyEntity;
import com.survey.services.model.repository.AnswerRepository;
import com.survey.services.model.repository.QuestionRepository;
import com.survey.services.model.repository.SurveyAnswerRepository;
import com.survey.services.model.repository.SurveyRepository;
import com.survey.services.rest.dto.SurveyDetailResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;
import com.survey.services.rest.dto.SurveyRequest;
import com.survey.services.rest.service.SurveyService;

@Service
public class SurveyServiceImplement implements SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private SurveyAnswerRepository surveyAnswerRepository;

	@Override
	public List<SurveyGenericResponse> getSurveys() {
		
		List<SurveyEntity> surveys = surveyRepository.findAll();
			    
	    return SurveyMapper.INSTANCE.surveyEntityListToSurveyResponseList(surveys);
	}

	@Override
	public SurveyDetailResponse findById(Long id) {
		Optional<SurveyEntity> surveyOptional =  surveyRepository.findById(id);
	     
		SurveyDetailResponse response = null;
		
		if(surveyOptional.isPresent()) 
			response = SurveyMapper.INSTANCE.surveyEntityTosurveyDetailResponse(surveyOptional.get(), 
					SurveyMapper.INSTANCE.surveyAnswerIdToQuestionAnswerResponseList(surveyOptional.get().getSurveyAnswerId()));
			
		return response;
	}

	@Override
	public Boolean save(SurveyRequest request) {
		
		SurveyEntity surveyEntity = new SurveyEntity();
		surveyEntity.setClientName(request.getClientName());
		surveyRepository.save(surveyEntity);
		
		request.getQuestions().forEach(item->{
			
			Optional<QuestionEntity> questionOptional = questionRepository.findById(item.getQuestionId());	
			Optional<AnswerEntity> answerOptional = answerRepository.findById(item.getAnswerId());
			
			SurveyAnswerEntity surveyAnswerEntity = new SurveyAnswerEntity();
			surveyAnswerEntity.setSurveyId(surveyEntity);
			surveyAnswerEntity.setQuestionId(questionOptional.get());
			surveyAnswerEntity.setAnswerId(answerOptional.get());
			surveyAnswerEntity.setAdicionalAnswer(item.getAdicionalAnswer());
			
			surveyAnswerRepository.save(surveyAnswerEntity);
		});
		
	    
		return Boolean.TRUE;
	}

}
