package com.interview.career.dto.request;

import lombok.Data;

@Data
public class CareerPreferenceRequest {
    private Long userId;
    private Long fieldId;
    private Long topicId;
}
