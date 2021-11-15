package com.survey.services.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDetailResponse {
	
	private Long id;
	private String clientName;
	private List<QuestionAnswerResponse> questions;

}
