package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repo,
                                     StudentProfileRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {

        StudentProfile a = studentRepo.findById(assignment.getStudentAId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        StudentProfile b = studentRepo.findById(assignment.getStudentBId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (!Boolean.TRUE.equals(a.getActive()) || !Boolean.TRUE.equals(b.getActive())) {
            throw new IllegalArgumentException("both students must be active");
        }

        assignment.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        assignment.setAssignedAt(LocalDateTime.now());
        return repo.save(assignment);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord r = getAssignmentById(id);
        r.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(r);
    }
}
