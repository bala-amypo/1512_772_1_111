package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        if (r.getStudentAId() <= 0 || r.getStudentBId() <= 0) {
            throw new IllegalArgumentException("Invalid student");
        }
        r.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repo.save(r);
    }

    @Override
    public RoomAssignmentRecord updateStatus(long id, String status) {
        RoomAssignmentRecord r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
}
