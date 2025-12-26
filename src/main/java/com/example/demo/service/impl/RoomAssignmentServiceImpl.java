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
    public RoomAssignmentRecord assign(RoomAssignmentRecord record) {
        record.setStatus(RoomAssignmentRecord.Status.ASSIGNED);
        return repo.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public RoomAssignmentRecord updateStatus(long id, String status) {
        RoomAssignmentRecord r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }
}
