package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    // ✅ Used by Spring
    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
        this.scoreRepo = null;
    }

    // ✅ Used by tests
    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo,
                                   CompatibilityScoreRecordRepository scoreRepo) {
        this.repo = repo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record) {
        return repo.save(record);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(long id, String status) {
        MatchAttemptRecord rec = repo.findById(id).orElseThrow();
        rec.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(rec);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(long studentId) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(studentId, studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
}
