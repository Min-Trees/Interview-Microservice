package com.interview.news.dto.request;

import lombok.Data;

@Data
public class NewsRequest {
    private Long userId;
    private String title;
    private String content;
    private Long fieldId;
    private Long examId;
}
