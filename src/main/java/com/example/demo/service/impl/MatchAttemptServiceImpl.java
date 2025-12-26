package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record) {
        record.setAttemptedAt(LocalDateTime.now());
        if (record.getStatus() == null) {
            record.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return repo.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(long studentId) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        record.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(record);
    }
}
