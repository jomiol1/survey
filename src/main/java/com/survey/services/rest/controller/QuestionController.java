package com.survey.services.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.services.constant.StatusCode;
import com.survey.services.rest.dto.GenericResponse;
import com.survey.services.rest.dto.QuestionResponse;
import com.survey.services.rest.service.QuestionService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/question")
@Api(
        value = "/question",
        produces = "application/json")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<List<QuestionResponse>> getAll() {
    	GenericResponse<List<QuestionResponse>> response = new GenericResponse<>();
    	response.setData(questionService.getQuestions());
    	response.setMessage(StatusCode.OK.getDescription());
    	response.setStatusCode(StatusCode.OK.getCode());
    	
        return response;
    }

}
