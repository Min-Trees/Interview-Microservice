package com.interview.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
