package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoomAssignmentRecord addRoom(RoomAssignmentRecord room) {
        return repo.save(room);
    }

    @Override
    public List<RoomAssignmentRecord> getAllRooms() {
        return repo.findAll();
    }
}
