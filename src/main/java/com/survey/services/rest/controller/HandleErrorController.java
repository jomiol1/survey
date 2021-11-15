package com.survey.services.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.survey.services.constant.StatusCode;
import com.survey.services.rest.dto.GenericResponse;


@RestController
@CrossOrigin(origins = "*")
public class HandleErrorController {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public GenericResponse<Void> handlerExceptionGeneral(Exception ex){
    	GenericResponse<Void> response = new GenericResponse<>();
    	response.setMessage(StatusCode.INTERNAL_SERVER_ERROR.getDescription());
    	response.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR.getCode());
    	
    	return response;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public GenericResponse<String> handlerExceptionBadRequest(Exception ex){
    	GenericResponse<String> response = new GenericResponse<>();
    	response.setMessage(StatusCode.BAD_REQUEST.getDescription());
    	response.setStatusCode(StatusCode.BAD_REQUEST.getCode());
    	response.setData(ex.getMessage());
    	
    	return response;
	}

}
