package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {
    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord a);
    MatchAttemptRecord updateAttemptStatus(long id, String status);
    List<MatchAttemptRecord> getAllMatchAttempts();
}
