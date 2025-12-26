package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record);

    MatchAttemptRecord updateAttemptStatus(long id, String status);

    List<MatchAttemptRecord> getAttemptsByStudent(long studentId);

    List<MatchAttemptRecord> getAllMatchAttempts();
}
