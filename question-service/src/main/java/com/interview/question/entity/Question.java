package com.interview.question.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;

    @Lob
    private String questionContent;

    @Lob
    private String questionAnswer;

    private Float similarityScore;

    @Enumerated(EnumType.STRING)
    private QuestionStatus status;

    @Column(length = 10)
    private String language;

    private LocalDateTime createdAt;
    private LocalDateTime approvedAt;
    private Long approvedBy;
    private Integer usefulVote;
    private Integer unusefulVote;
}
