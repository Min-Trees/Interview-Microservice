package com.interview.news.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class News {

    @Id
    private Long id;
}
