package com.interview.user.repository;

import com.interview.user.entity.EloHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EloHistoryRepository extends JpaRepository<EloHistory, Long> {
}
