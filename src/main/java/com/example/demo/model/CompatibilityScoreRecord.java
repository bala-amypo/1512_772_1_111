package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compatibility_scores",
       uniqueConstraints = @UniqueConstraint(columnNames = {"studentAId", "studentBId"}))
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String detailsJson;

    public enum CompatibilityLevel { LOW, MEDIUM, HIGH, EXCELLENT }

    public CompatibilityScoreRecord() {}

    // Getters & Setters

    public Long getId() { return id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) { this.compatibilityLevel = compatibilityLevel; }

    public LocalDateTime getComputedAt() { return computedAt; }

    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String detailsJson) { this.detailsJson = detailsJson; }
}
