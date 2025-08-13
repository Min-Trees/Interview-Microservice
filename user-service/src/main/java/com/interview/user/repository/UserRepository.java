package com.interview.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
