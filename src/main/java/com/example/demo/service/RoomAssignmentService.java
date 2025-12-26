package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;

import java.util.List;

public interface RoomAssignmentService {

    RoomAssignmentRecord assignRoom(RoomAssignmentRecord record);

    List<RoomAssignmentRecord> getAllAssignments();

    RoomAssignmentRecord getAssignmentById(Long id);
}
