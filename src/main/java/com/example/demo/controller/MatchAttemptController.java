package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long initiatorStudentId;
    private long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Status {
        PENDING,
        MATCHED,
        REJECTED
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(long initiatorStudentId) { this.initiatorStudentId = initiatorStudentId; }

    public long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(long candidateStudentId) { this.candidateStudentId = candidateStudentId; }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long resultScoreId) { this.resultScoreId = resultScoreId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
