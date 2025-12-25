package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {
    RoomAssignmentRecord save(RoomAssignmentRecord r);
    List<RoomAssignmentRecord> getAll();
}
