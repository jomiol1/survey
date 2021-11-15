package com.survey.services.rest.service;

import java.util.List;

import com.survey.services.rest.dto.SurveyDetailResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;
import com.survey.services.rest.dto.SurveyRequest;

public interface SurveyService {
	
    public List<SurveyGenericResponse> getSurveys();
    
    public SurveyDetailResponse findById(Long id);
    
    public Boolean save(SurveyRequest request);

}
