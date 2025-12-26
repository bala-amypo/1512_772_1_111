package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

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
    public RoomAssignmentRecord assignRoom(Long studentId, String room) {
        StudentProfile student = studentRepo.findById(studentId).orElseThrow();

        RoomAssignmentRecord record = new RoomAssignmentRecord();
        record.setStudent(student);
        record.setRoomNumber(room);
        record.setStatus(RoomAssignmentRecord.Status.ASSIGNED);

        return roomRepo.save(record);
    }
}
