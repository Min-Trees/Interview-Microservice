package com.interview.question.dto.request;

import lombok.Data;

@Data
public class QuestionRequest {
    private Long userId;
    private Long topicId;
    private Long fieldId;
    private Long levelId;
    private Long questionTypeId;
    private String questionContent;
    private String questionAnswer;
    private String language;
}
