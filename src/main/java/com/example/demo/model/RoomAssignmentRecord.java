package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    public enum Status { PENDING, APPROVED, REJECTED }

    @Id @GeneratedValue
    private Long id;

    private Long studentAId;
    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() { return id; }
    public Long getStudentAId() { return studentAId; }
    public Long getStudentBId() { return studentBId; }
    public Status getStatus() { return status; }

    public void setStudentAId(Long id) { this.studentAId = id; }
    public void setStudentBId(Long id) { this.studentBId = id; }
    public void setStatus(Status s) { this.status = s; }
}
