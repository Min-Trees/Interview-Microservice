package com.interview.news.service;

import com.interview.news.dto.request.NewsRequest;
import com.interview.news.dto.response.NewsResponse;
import com.interview.news.entity.News;
import com.interview.news.mapper.NewsMapper;
import com.interview.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsResponse createNews(NewsRequest request) {
        News news = newsMapper.toEntity(request);
        news.setCreatedAt(LocalDateTime.now());
        return newsMapper.toResponse(newsRepository.save(news));
    }

    public NewsResponse getById(Long id) {
        return newsRepository.findById(id)
                .map(newsMapper::toResponse)
                .orElse(null);
    }
}
