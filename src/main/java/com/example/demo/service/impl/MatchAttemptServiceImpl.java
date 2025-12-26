package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository matchRepo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository matchRepo) {
        this.matchRepo = matchRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record) {
        record.setAttemptedAt(LocalDateTime.now());
        record.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        return matchRepo.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return matchRepo.findAll();
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(long studentId) {
        return matchRepo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord record = matchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        record.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return matchRepo.save(record);
    }
}
