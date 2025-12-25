package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CompatibilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentA;
    private Long studentB;
    private int score;

    public Long getId() { return id; }
    public Long getStudentA() { return studentA; }
    public Long getStudentB() { return studentB; }
    public int getScore() { return score; }

    public void setStudentA(Long studentA) { this.studentA = studentA; }
    public void setStudentB(Long studentB) { this.studentB = studentB; }
    public void setScore(int score) { this.score = score; }
}
