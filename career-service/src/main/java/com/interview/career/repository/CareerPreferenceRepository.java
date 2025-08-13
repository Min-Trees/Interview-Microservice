package com.interview.career.repository;

import com.interview.career.entity.CareerPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerPreferenceRepository extends JpaRepository<CareerPreference, Long> {
}
