package com.interview.exam.mapper;

import org.mapstruct.Mapper;
import com.interview.exam.dto.request.ExamRequest;
import com.interview.exam.dto.response.ExamResponse;
import com.interview.exam.entity.Exam;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toEntity(ExamRequest request);

    ExamResponse toResponse(Exam exam);
}
