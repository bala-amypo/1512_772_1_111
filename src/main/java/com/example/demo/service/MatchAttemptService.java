package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {
    MatchAttemptRecord save(MatchAttemptRecord r);
    List<MatchAttemptRecord> getAll();
}
