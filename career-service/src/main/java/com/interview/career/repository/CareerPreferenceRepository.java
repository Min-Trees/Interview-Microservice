package com.interview.career.repository;

import com.interview.career.entity.CareerPreference;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CareerPreferenceRepository extends JpaRepository<CareerPreference, Long> {
    List<CareerPreference> findByUserId(Long userId);

public interface CareerPreferenceRepository extends JpaRepository<CareerPreference, Long> {

}
