package com.interview.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.interview.question.dto.request.QuestionRequest;
import com.interview.question.dto.response.QuestionResponse;
import com.interview.question.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "topic.id", source = "topicId")
    @Mapping(target = "field.id", source = "fieldId")
    @Mapping(target = "level.id", source = "levelId")
    @Mapping(target = "questionType.id", source = "questionTypeId")
    Question toEntity(QuestionRequest request);

    @Mapping(target = "topicId", source = "topic.id")
    @Mapping(target = "fieldId", source = "field.id")
    @Mapping(target = "levelId", source = "level.id")
    @Mapping(target = "questionTypeId", source = "questionType.id")
    QuestionResponse toResponse(Question question);
}
