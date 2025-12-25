package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;

import java.util.List;
import java.util.Optional;

public interface MatchAttemptService {

    MatchAttemptRecord createAttempt(MatchAttemptRecord attempt);

    Optional<MatchAttemptRecord> getAttempt(Long id);

    List<MatchAttemptRecord> getAllAttempts();

    MatchAttemptRecord updateAttemptStatus(Long id, String status);
}
