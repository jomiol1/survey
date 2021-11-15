package com.survey.services.rest.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerRequest {
	
	@NotNull
	private Long questionId;
	@NotNull
	private Long answerId;
	
	private String adicionalAnswer;
	
}
