package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RoomAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long student1;
    private Long student2;
    private String roomNumber;

    public Long getId() { return id; }
    public Long getStudent1() { return student1; }
    public Long getStudent2() { return student2; }
    public String getRoomNumber() { return roomNumber; }

    public void setStudent1(Long student1) { this.student1 = student1; }
    public void setStudent2(Long student2) { this.student2 = student2; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
}
