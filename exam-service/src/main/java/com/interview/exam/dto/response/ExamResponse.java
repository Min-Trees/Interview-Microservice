package com.interview.exam.dto.response;

import com.interview.exam.entity.ExamStatus;
import com.interview.exam.entity.ExamType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamResponse {
    private Long id;
    private Long userId;
    private ExamType examType;
    private String title;
    private String position;
    private String topics;
    private String questionTypes;
    private Integer questionCount;
    private Integer duration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ExamStatus status;
    private String language;
    private LocalDateTime createdAt;
    private Long createdBy;
}
