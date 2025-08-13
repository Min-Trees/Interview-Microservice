package com.interview.question.service;

import com.interview.question.dto.request.QuestionRequest;
import com.interview.question.dto.response.QuestionResponse;
import com.interview.question.entity.Question;
import com.interview.question.entity.QuestionStatus;
import com.interview.question.mapper.QuestionMapper;
import com.interview.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionResponse createQuestion(QuestionRequest request) {
        Question question = questionMapper.toEntity(request);
        question.setStatus(QuestionStatus.PENDING);
        question.setCreatedAt(LocalDateTime.now());
        question.setUsefulVote(0);
        question.setUnusefulVote(0);
        return questionMapper.toResponse(questionRepository.save(question));
        }

    public QuestionResponse getById(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::toResponse)
                .orElse(null);
    }
}
