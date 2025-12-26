package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository roomRepo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository roomRepo,
                                     StudentProfileRepository studentRepo) {
        this.roomRepo = roomRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assign(RoomAssignmentRecord record) {
        return roomRepo.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(long studentId) {
        return roomRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public RoomAssignmentRecord updateStatus(long id, String status) {
        RoomAssignmentRecord r = roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        r.setStatus(status);
        return roomRepo.save(r);
    }
}
