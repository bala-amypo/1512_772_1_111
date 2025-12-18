package com.example.demo.service;

import java.util.List;
import com.example.demo.model.CompatibilityScore;

public interface CompatibilityScoreService {

    CompatibilityScore addScore(CompatibilityScore score);
    List<CompatibilityScore> getAllScores();
}
