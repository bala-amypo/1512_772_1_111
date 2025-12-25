package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.MatchAttemptRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

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
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return repo.findAll();
    }
    @Override
public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
    MatchAttemptRecord a = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("not found"));
    a.setStatus(status);
    return repo.save(a);
}

}
