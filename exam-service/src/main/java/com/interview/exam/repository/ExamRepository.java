package com.interview.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
