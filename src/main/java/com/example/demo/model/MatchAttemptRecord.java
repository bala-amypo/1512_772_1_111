package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    private LocalDateTime attemptedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING_REVIEW,
        MATCHED,
        REJECTED
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(long id) { this.initiatorStudentId = id; }

    public Long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(long id) { this.candidateStudentId = id; }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(long id) { this.resultScoreId = id; }

    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDateTime attemptedAt) { this.attemptedAt = attemptedAt; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
