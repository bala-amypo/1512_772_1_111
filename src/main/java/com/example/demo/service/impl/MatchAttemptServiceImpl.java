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
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord a) {
        if (a.getResultScoreId() != null) {
            a.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            a.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        a.setAttemptedAt(LocalDateTime.now());
        return repo.save(a);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(long id, String status) {
        MatchAttemptRecord a = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        a.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(a);
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
}
