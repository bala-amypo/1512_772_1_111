package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
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
    public RoomAssignmentRecord assignRoom(Long studentId, String roomNumber) {
        StudentProfile student = studentRepo.findById(studentId).orElseThrow();

        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudentProfile(student);
        record.setRoomNumber(roomNumber);
        record.setStatus(RoomAssignmentRecord.Status.ASSIGNED);

        return roomRepo.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(long id) {
        return roomRepo.findById(id).orElseThrow();
    }

    @Override
    public List<RoomAssignmentRecord> getAll() {
        return roomRepo.findAll();
    }
}
