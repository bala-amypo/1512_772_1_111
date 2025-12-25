package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MatchAttemptRecord {

    public enum Status { SUCCESS, FAILED }

    @Id @GeneratedValue
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private Long resultScoreId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void setResultScoreId(long id) { this.resultScoreId = id; }
    public void setStatus(Status s) { this.status = s; }

    public Status getStatus() { return status; }
}
