package com.interview.question.controller;

import com.interview.question.dto.request.QuestionRequest;
import com.interview.question.dto.response.QuestionResponse;
import com.interview.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/questions")
    public QuestionResponse createQuestion(@RequestBody @Valid QuestionRequest request) {
        return questionService.createQuestion(request);
    }

    @GetMapping("/questions/{id}")
    public QuestionResponse getQuestion(@PathVariable Long id) {
        return questionService.getById(id);
    }
}
