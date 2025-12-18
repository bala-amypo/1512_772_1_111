package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.CompatibilityScore;
import com.example.demo.repository.CompatibilityScoreRepository;

@Service
public class CompatibilityScoreServiceImpl
        implements CompatibilityScoreService {

    private final CompatibilityScoreRepository repo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRepository repo) {
        this.repo = repo;
    }

    @Override
    public CompatibilityScore addScore(CompatibilityScore score) {
        return repo.save(score);
    }

    @Override
    public List<CompatibilityScore> getAllScores() {
        return repo.findAll();
    }
}
