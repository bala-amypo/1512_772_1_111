package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;

    public MatchAttemptServiceImpl(MatchAttemptRecordRepository repo) { this.repo = repo; }

    public MatchAttemptRecord save(MatchAttemptRecord r) {
        return repo.save(r);
    }

    public List<MatchAttemptRecord> getAll() {
        return repo.findAll();
    }
}
