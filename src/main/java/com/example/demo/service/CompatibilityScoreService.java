package com.example.demo.service;

import com.example.demo.model.CompatibilityScore;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScore computeScore(Long a, Long b);
    List<CompatibilityScore> getAllScores();
}
