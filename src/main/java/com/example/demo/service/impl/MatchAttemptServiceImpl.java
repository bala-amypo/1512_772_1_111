package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public MatchAttemptRecord createAttempt(MatchAttemptRecord attempt) {
        attempt.setAttemptedAt(LocalDateTime.now());
        return repo.save(attempt);
    }

    @Override
    public Optional<MatchAttemptRecord> getAttempt(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<MatchAttemptRecord> getAllAttempts() {
        return repo.findAll();
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord record = repo.findById(id).orElseThrow();
        record.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(record);
    }
}
