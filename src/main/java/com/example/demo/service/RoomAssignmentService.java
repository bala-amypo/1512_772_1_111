package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {
    RoomAssignmentRecord assign(RoomAssignmentRecord record);
    List<RoomAssignmentRecord> getAssignmentsByStudent(long studentId);
    RoomAssignmentRecord updateStatus(long id, String status);
}
