package com.survey.services.rest.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SurveyRequest {
	
	@NotNull
	@NotEmpty
	private String clientName;
	
	@Valid
	private List<QuestionAnswerRequest> questions;
	
}
