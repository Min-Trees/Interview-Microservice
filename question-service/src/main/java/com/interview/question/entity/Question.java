package com.interview.question.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question {

    @Id
    private Long id;
}
