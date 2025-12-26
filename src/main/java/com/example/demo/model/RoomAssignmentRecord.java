package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_assignments")
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long studentAId;
    private long studentBId;
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE,
        COMPLETED
    }

    public Long getId() { return id; }
    public long getStudentAId() { return studentAId; }
    public void setStudentAId(long id) { this.studentAId = id; }
    public long getStudentBId() { return studentBId; }
    public void setStudentBId(long id) { this.studentBId = id; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String r) { this.roomNumber = r; }
    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }
}
