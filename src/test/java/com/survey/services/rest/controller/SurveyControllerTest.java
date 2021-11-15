package com.survey.services.rest.controller;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.survey.services.rest.dto.SurveyDetailResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;
import com.survey.services.rest.dto.SurveyRequest;
import com.survey.services.rest.service.SurveyService;

public class SurveyControllerTest {
	
	@Mock
	private SurveyService surveyService;
	
	@InjectMocks
	private SurveyController surveyController;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void saveTest() {
		Mockito.when(surveyService.save(Mockito.any())).thenReturn(Boolean.TRUE);
		Assert.assertNotNull(surveyController.save(new SurveyRequest()));
	}
	
	@Test
	void findByIdTest() {
		Mockito.when(surveyService.findById(Mockito.anyLong())).thenReturn(new SurveyDetailResponse());
		Assert.assertNotNull(surveyController.findById(Long.valueOf(1)));
	}
	
	@Test
	void getAllSurveysTest() {
		Mockito.when(surveyService.getSurveys()).thenReturn(new ArrayList<SurveyGenericResponse>());
		Assert.assertNotNull(surveyController.getAll());
	}

}
