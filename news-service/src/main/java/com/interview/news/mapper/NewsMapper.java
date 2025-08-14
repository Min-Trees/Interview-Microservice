package com.interview.news.mapper;

import org.mapstruct.Mapper;
import com.interview.news.dto.request.NewsRequest;
import com.interview.news.dto.response.NewsResponse;
import com.interview.news.entity.News;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    News toEntity(NewsRequest request);

    NewsResponse toResponse(News news);
}
