package com.survey.services.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.survey.services.model.entity.SurveyAnswerEntity;
import com.survey.services.model.entity.SurveyEntity;
import com.survey.services.rest.dto.QuestionAnswerResponse;
import com.survey.services.rest.dto.SurveyDetailResponse;
import com.survey.services.rest.dto.SurveyGenericResponse;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SurveyMapper {
	
	SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);
	
	@Mapping(target = "description", source = "clientName")
	SurveyGenericResponse surveyEntityToSurveyResponse(SurveyEntity entity);

	List<SurveyGenericResponse> surveyEntityListToSurveyResponseList(List<SurveyEntity> entityList);
	
	@Mapping(target = "question", source = "questionId.question")
	@Mapping(target = "answer", source = "answerId.answer")
	QuestionAnswerResponse surveyAnswerEntitytoQuestionAnswerResponse(SurveyAnswerEntity surveyAnswerEntity);
	
	List<QuestionAnswerResponse> surveyAnswerIdToQuestionAnswerResponseList(List<SurveyAnswerEntity> surveyAnswerId);
	
	SurveyDetailResponse surveyEntityTosurveyDetailResponse(SurveyEntity surveyEntity, List<QuestionAnswerResponse> questions);


}
