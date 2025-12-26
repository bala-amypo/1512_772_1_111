package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(RoomAssignmentRecord r);

    RoomAssignmentRecord getAssignmentById(long id);

    List<RoomAssignmentRecord> getAssignmentsByStudent(long id);

    RoomAssignmentRecord updateStatus(long id, String status);
}
