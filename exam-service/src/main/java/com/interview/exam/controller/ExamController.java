package com.interview.exam.controller;

import com.interview.exam.dto.request.ExamRequest;
import com.interview.exam.dto.response.ExamResponse;
import com.interview.exam.service.ExamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping("/exams")
    public ExamResponse createExam(@RequestBody @Valid ExamRequest request) {
        return examService.createExam(request);
    }

    @GetMapping("/exams/{id}")
    public ExamResponse getExam(@PathVariable Long id) {
        return examService.getById(id);
    }
}
