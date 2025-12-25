package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "compatibility_scores",
    uniqueConstraints = @UniqueConstraint(columnNames = {"studentAId", "studentBId"})
)
public class CompatibilityScoreRecord {

    public enum CompatibilityLevel { LOW, MEDIUM, HIGH, EXCELLENT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt = LocalDateTime.now();

    @Lob
    private String detailsJson;

    public CompatibilityScoreRecord() {}

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public Long getStudentBId() { return studentBId; }
    public Double getScore() { return score; }
    public CompatibilityLevel getCompatibilityLevel() { return compatibilityLevel; }
    public LocalDateTime getComputedAt() { return computedAt; }
    public String getDetailsJson() { return detailsJson; }

    public void setId(Long id) { this.id = id; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }
    public void setScore(Double score) { this.score = score; }
    public void setCompatibilityLevel(CompatibilityLevel compatibilityLevel) { this.compatibilityLevel = compatibilityLevel; }
    public void setDetailsJson(String detailsJson) { this.detailsJson = detailsJson; }
}
