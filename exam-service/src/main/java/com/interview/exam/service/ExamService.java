package com.interview.exam.service;

import com.interview.exam.dto.request.ExamRequest;
import com.interview.exam.dto.response.ExamResponse;
import com.interview.exam.entity.Exam;
import com.interview.exam.entity.ExamStatus;
import com.interview.exam.mapper.ExamMapper;
import com.interview.exam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    public ExamResponse createExam(ExamRequest request) {
        Exam exam = examMapper.toEntity(request);
        exam.setStatus(ExamStatus.ACTIVE);
        exam.setCreatedAt(LocalDateTime.now());
        exam.setCreatedBy(request.getUserId());
        return examMapper.toResponse(examRepository.save(exam));
    }

    public ExamResponse getById(Long id) {
        return examRepository.findById(id)
                .map(examMapper::toResponse)
                .orElse(null);
    }
}
