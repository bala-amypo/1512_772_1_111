package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(Long studentId, String roomNumber);

    RoomAssignmentRecord getAssignmentById(long id);

    List<RoomAssignmentRecord> getAll();
}
