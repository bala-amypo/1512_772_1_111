package com.example.demo.service;

import com.example.demo.model.CompatibilityScore;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScore addScore(CompatibilityScore score);
    List<CompatibilityScore> getAllScores();
}
