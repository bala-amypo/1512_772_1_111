package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;

import java.util.List;

public interface MatchAttemptService {

    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord record);

    List<MatchAttemptRecord> getAllMatchAttempts();

    List<MatchAttemptRecord> getAttemptsByStudent(long studentId);

    MatchAttemptRecord updateAttemptStatus(Long id, String status);
}
