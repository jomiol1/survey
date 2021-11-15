package com.survey.services.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerResponse {
	
	private String question;
	private String answer;
	private String adicionalAnswer;

}
