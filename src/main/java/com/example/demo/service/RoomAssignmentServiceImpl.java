package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) { this.repo = repo; }

    public RoomAssignmentRecord save(RoomAssignmentRecord r) {
        return repo.save(r);
    }

    public List<RoomAssignmentRecord> getAll() {
        return repo.findAll();
    }
}
