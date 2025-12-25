package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_attempts")
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long initiatorStudentId;
    private Long candidateStudentId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime attemptedAt = LocalDateTime.now();

    public enum Status { MATCHED, NOT_COMPATIBLE, PENDING_REVIEW }

    public MatchAttemptRecord() {}

    // Getters & Setters

    public Long getId() { return id; }

    public Long getInitiatorStudentId() { return initiatorStudentId; }
    public void setInitiatorStudentId(Long initiatorStudentId) { this.initiatorStudentId = initiatorStudentId; }

    public Long getCandidateStudentId() { return candidateStudentId; }
    public void setCandidateStudentId(Long candidateStudentId) { this.candidateStudentId = candidateStudentId; }

    public Long getResultScoreId() { return resultScoreId; }
    public void setResultScoreId(Long resultScoreId) { this.resultScoreId = resultScoreId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setId(Long id) {
    this.id = id;
}

}
