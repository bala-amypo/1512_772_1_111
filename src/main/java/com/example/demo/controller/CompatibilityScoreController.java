package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute/{a}/{b}")
    public ResponseEntity<CompatibilityScoreRecord> compute(@PathVariable Long a, @PathVariable Long b) {
        return ResponseEntity.ok(service.computeScore(a, b));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getForStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScoresForStudent(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityScoreRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScoreById(id));
    }

    @GetMapping
    public ResponseEntity<List<CompatibilityScoreRecord>> getAll() {
        return ResponseEntity.ok(service.getAllScores());
    }
}
