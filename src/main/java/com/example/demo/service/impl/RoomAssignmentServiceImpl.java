package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo,
                                     StudentProfileRepository ignored) {
        this.repo = repo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        r.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repo.save(r);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    @Override
    public RoomAssignmentRecord updateStatus(long id, String status) {
        RoomAssignmentRecord r = repo.findById(id).orElse(null);
        if (r == null) return null;
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }
}
