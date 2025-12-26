package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatchAttemptRecord> create(@RequestBody MatchAttemptRecord r) {
        return ResponseEntity.ok(service.logMatchAttempt(r));
    }
}
