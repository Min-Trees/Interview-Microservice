package com.interview.exam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private ExamType examType;

    @Column(length = 255)
    private String title;

    @Column(length = 100)
    private String position;

    @Column(length = 500)
    private String topics;

    @Column(length = 100)
    private String questionTypes;

    private Integer questionCount;

    private Integer duration;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ExamStatus status;

    @Column(length = 10)
    private String language;

    private LocalDateTime createdAt;

    private Long createdBy;
}
