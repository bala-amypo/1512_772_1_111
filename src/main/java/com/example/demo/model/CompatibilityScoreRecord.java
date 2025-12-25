package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    @Id @GeneratedValue
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private double score;

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public Long getStudentBId() { return studentBId; }
    public double getScore() { return score; }

    public void setStudentAId(Long id) { this.studentAId = id; }
    public void setStudentBId(Long id) { this.studentBId = id; }
    public void setScore(double s) { this.score = s; }
}
