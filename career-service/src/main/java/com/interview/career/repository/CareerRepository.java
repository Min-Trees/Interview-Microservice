package com.interview.career.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.career.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
