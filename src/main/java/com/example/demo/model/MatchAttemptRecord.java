package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_attempts")
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long initiatorStudentId;
    private long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt;

    public enum Status {
        PENDING_REVIEW,
        MATCHED
    }

    public Long getId() { return id; }
    public long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(long id) { this.initiatorStudentId = id; }
    public long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(long id) { this.candidateStudentId = id; }
    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long id) { this.resultScoreId = id; }
    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }
    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDateTime t) { this.attemptedAt = t; }
}
