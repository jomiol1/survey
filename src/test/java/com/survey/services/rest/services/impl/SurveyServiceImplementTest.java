package com.survey.services.rest.services.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.survey.services.model.entity.AnswerEntity;
import com.survey.services.model.entity.QuestionEntity;
import com.survey.services.model.entity.SurveyEntity;
import com.survey.services.model.repository.AnswerRepository;
import com.survey.services.model.repository.QuestionRepository;
import com.survey.services.model.repository.SurveyAnswerRepository;
import com.survey.services.model.repository.SurveyRepository;
import com.survey.services.rest.dto.QuestionAnswerRequest;
import com.survey.services.rest.dto.SurveyRequest;
import com.survey.services.rest.service.impl.SurveyServiceImplement;

public class SurveyServiceImplementTest {
	
	@Mock
	private SurveyRepository surveyRepository;
	
	@Mock
	private QuestionRepository questionRepository;
	
	@Mock
	private AnswerRepository answerRepository;
	
	@Mock
	private SurveyAnswerRepository surveyAnswerRepository;
	
	@InjectMocks
	private SurveyServiceImplement surveyService;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void saveTest() {
		List<QuestionAnswerRequest> questions = new ArrayList<>();
		questions.add(new QuestionAnswerRequest(Long.valueOf(1),Long.valueOf(1),""));
		
		SurveyRequest request = new SurveyRequest();
		request.setClientName("a");
		request.setQuestions(questions);
		
		Optional<QuestionEntity> questionOptional = Optional.of(new QuestionEntity());
		Optional<AnswerEntity> answerOptional = Optional.of(new AnswerEntity());
		
		Mockito.when(questionRepository.findById(Mockito.anyLong())).thenReturn(questionOptional);
		Mockito.when(answerRepository.findById(Mockito.anyLong())).thenReturn(answerOptional);
		
		Mockito.when(surveyRepository.save(Mockito.any())).thenReturn(new SurveyEntity());
		
		assertNotNull(surveyService.save(request));
	}
	
	@Test
	void getSurveysTest() {
		List<SurveyEntity> surveys = new ArrayList<>();
		
		Mockito.when(surveyRepository.findAll()).thenReturn(surveys);
		assertNotNull(surveyService.getSurveys());
	}
	
	@Test
	void findByIdTest() {
		Optional<SurveyEntity> surveyOptional = Optional.of(new SurveyEntity());
		
		Mockito.when(surveyRepository.findById(Mockito.anyLong())).thenReturn(surveyOptional);
		assertNotNull(surveyService.findById(Long.valueOf(1)));
	}

}
