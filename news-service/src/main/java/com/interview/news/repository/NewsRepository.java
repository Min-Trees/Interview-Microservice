package com.interview.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.news.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
