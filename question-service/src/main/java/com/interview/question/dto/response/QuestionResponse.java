package com.interview.question.dto.response;

import com.interview.question.entity.QuestionStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionResponse {
    private Long id;
    private Long userId;
    private Long topicId;
    private Long fieldId;
    private Long levelId;
    private Long questionTypeId;
    private String questionContent;
    private String questionAnswer;
    private Float similarityScore;
    private QuestionStatus status;
    private String language;
    private LocalDateTime createdAt;
    private LocalDateTime approvedAt;
    private Long approvedBy;
    private Integer usefulVote;
    private Integer unusefulVote;
}
