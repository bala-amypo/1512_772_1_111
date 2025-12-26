package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_assignment_records")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;

    private Long studentBId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ASSIGNED,
        CANCELLED,
        COMPLETED
    }

    // Constructors
    public RoomAssignmentRecord() {
    }

    public RoomAssignmentRecord(Long studentAId, Long studentBId, Status status) {
        this.studentAId = studentAId;
        this.studentBId = studentBId;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public Long getStudentAId() {
        return studentAId;
    }

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public Long getStudentBId() {
        return studentBId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
