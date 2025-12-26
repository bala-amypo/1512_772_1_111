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
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo,
                                     StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord record) {
        return repo.save(record);
    }

    @Override
    public RoomAssignmentRecord updateStatus(long id, String status) {
        RoomAssignmentRecord r = repo.findById(id).orElseThrow();
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(long id) {
        return repo.findById(id).orElseThrow();
    }
}
