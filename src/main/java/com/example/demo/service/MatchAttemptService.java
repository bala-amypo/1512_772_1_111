package com.example.demo.service;

import java.util.List;
import com.example.demo.model.MatchAttemptRecord;

public interface MatchAttemptService {
    MatchAttemptRecord addAttempt(MatchAttemptRecord attempt);
    List<MatchAttemptRecord> getAllAttempts();
}
