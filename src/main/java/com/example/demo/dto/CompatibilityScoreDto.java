package com.example.demo.dto;

public class CompatibilityScoreDto {

    private Long studentAId;
    private Long studentBId;
    private Double score;
    private String compatibilityLevel;

    public CompatibilityScoreDto() {}

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(String compatibilityLevel) { this.compatibilityLevel = compatibilityLevel; }
}
