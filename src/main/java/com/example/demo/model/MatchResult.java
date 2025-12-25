package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentA;

    @ManyToOne(optional = false)
    private StudentProfile studentB;

    private Double score;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String reasonSummary;

    public MatchResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudentA() { return studentA; }
    public void setStudentA(StudentProfile studentA) { this.studentA = studentA; }

    public StudentProfile getStudentB() { return studentB; }
    public void setStudentB(StudentProfile studentB) { this.studentB = studentB; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getReasonSummary() { return reasonSummary; }
    public void setReasonSummary(String reasonSummary) { this.reasonSummary = reasonSummary; }
}
