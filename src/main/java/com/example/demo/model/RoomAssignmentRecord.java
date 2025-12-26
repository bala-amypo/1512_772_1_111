package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long studentAId;
    private long studentBId;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status {
        ACTIVE,
        COMPLETED,
        CANCELLED
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public long getStudentAId() { return studentAId; }
    public void setStudentAId(long studentAId) { this.studentAId = studentAId; }

    public long getStudentBId() { return studentBId; }
    public void setStudentBId(long studentBId) { this.studentBId = studentBId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
