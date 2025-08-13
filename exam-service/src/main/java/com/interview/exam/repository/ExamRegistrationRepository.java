package com.interview.exam.repository;

import com.interview.exam.entity.ExamRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long> {
}
