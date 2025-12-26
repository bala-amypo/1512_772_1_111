package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatchAttemptRecord> log(@RequestBody MatchAttemptRecord a) {
        return ResponseEntity.ok(service.logMatchAttempt(a));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<MatchAttemptRecord> update(@PathVariable long id,
                                                     @RequestParam String status) {
        return ResponseEntity.ok(service.updateAttemptStatus(id, status));
    }
}
