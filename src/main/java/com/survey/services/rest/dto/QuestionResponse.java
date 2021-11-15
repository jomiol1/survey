package com.survey.services.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResponse {
	
	private Long questionId;
	private String question;
	private List<SurveyGenericResponse> answers;
	
}
