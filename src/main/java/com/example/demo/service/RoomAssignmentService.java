package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(RoomAssignmentRecord record);

    RoomAssignmentRecord updateStatus(long id, String status);

    List<RoomAssignmentRecord> getAssignmentsByStudent(long studentId);

    List<RoomAssignmentRecord> getAllAssignments();

    RoomAssignmentRecord getAssignmentById(long id);
}
