package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {
    @Id @GeneratedValue
    private Long id;
    private Long studentId;
    private String roomNumber;

    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
}
