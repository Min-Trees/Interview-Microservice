package com.interview.news.controller;

import com.interview.news.dto.request.NewsRequest;
import com.interview.news.dto.response.NewsResponse;
import com.interview.news.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/news")
    public NewsResponse create(@RequestBody @Valid NewsRequest request) {
        return newsService.createNews(request);
    }

    @GetMapping("/news/{id}")
    public NewsResponse get(@PathVariable Long id) {
        return newsService.getById(id);
    }
}
