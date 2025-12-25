package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MatchAttemptRecord {
    @Id @GeneratedValue
    private Long id;
    private Long studentAId;
    private Long studentBId;

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }
    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }
}
