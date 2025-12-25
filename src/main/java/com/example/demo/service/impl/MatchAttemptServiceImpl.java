package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository attemptRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    // Constructor injection (order matters for tests)
    public MatchAttemptServiceImpl(MatchAttemptRecordRepository attemptRepo,
                                   CompatibilityScoreRecordRepository scoreRepo) {
        this.attemptRepo = attemptRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        attempt.setAttemptedAt(LocalDateTime.now());
        return attemptRepo.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return attemptRepo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long attemptId, String status) {
        MatchAttemptRecord record = attemptRepo.findById(attemptId)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        record.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return attemptRepo.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return attemptRepo.findAll();
    }
}
