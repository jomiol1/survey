package com.survey.services.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.services.constant.StatusCode;
import com.survey.services.rest.dto.GenericResponse;
import com.survey.services.rest.dto.SurveyDetailResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;
import com.survey.services.rest.dto.SurveyRequest;
import com.survey.services.rest.service.SurveyService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/survey-services")
@Api(
        value = "/survey",
        produces = "application/json")
public class SurveyController extends HandleErrorController{
	
	@Autowired
	private SurveyService surveyService;
	
    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<List<SurveyGenericResponse>> getAll() {
    	GenericResponse<List<SurveyGenericResponse>> response = new GenericResponse<>();
    	response.setData(surveyService.getSurveys());
    	response.setMessage(StatusCode.OK.getDescription());
    	response.setStatusCode(StatusCode.OK.getCode());
    	
        return response;
    }
    
    @GetMapping(
            path = "/findById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<SurveyDetailResponse> findById(@PathVariable Long id) {
      	GenericResponse<SurveyDetailResponse> response = new GenericResponse<>();
      	response.setData(surveyService.findById(id));
    	response.setMessage(StatusCode.OK.getDescription());
    	response.setStatusCode(StatusCode.OK.getCode());
    	
        return response;
    }
    
    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<Boolean> save(@RequestBody @Valid SurveyRequest request) {
      	GenericResponse<Boolean> response = new GenericResponse<>();
      	response.setData(surveyService.save(request));
    	response.setMessage(StatusCode.OK.getDescription());
    	response.setStatusCode(StatusCode.OK.getCode());
    	
        return response;
    }

}
