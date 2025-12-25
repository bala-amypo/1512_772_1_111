package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
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
        StudentProfile a = studentRepo.findById(record.getStudentAId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        StudentProfile b = studentRepo.findById(record.getStudentBId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (!a.getActive() || !b.getActive()) {
            throw new IllegalArgumentException("both students must be active");
        }

        return repo.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
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
        RoomAssignmentRecord record = getAssignmentById(id);
        record.setStatus(RoomAssignmentRecord.Status.valueOf(status));
        return repo.save(record);
    }
}
