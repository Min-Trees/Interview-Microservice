package com.interview.exam.dto.request;

import com.interview.exam.entity.ExamType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamRequest {
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
    private String language;
}
