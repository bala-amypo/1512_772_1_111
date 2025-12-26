package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {
    RoomAssignmentRecord assignRoom(RoomAssignmentRecord r);
    RoomAssignmentRecord updateStatus(long id, String status);
    List<RoomAssignmentRecord> getAllAssignments();
    RoomAssignmentRecord getAssignmentById(long id);
}
