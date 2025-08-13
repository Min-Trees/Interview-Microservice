package com.interview.news.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsResponse {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Long fieldId;
    private Long examId;
    private LocalDateTime createdAt;
}
