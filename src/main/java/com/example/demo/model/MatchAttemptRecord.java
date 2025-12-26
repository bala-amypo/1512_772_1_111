package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {
    public enum Status { MATCHED, NOT_COMPATIBLE, PENDING_REVIEW }

    @Id @GeneratedValue
    private Long id;
    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt;

    // getters & setters
}
