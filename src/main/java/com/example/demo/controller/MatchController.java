package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final CompatibilityScoreService service;

    public MatchController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/{studentAId}/{studentBId}")
    public CompatibilityScoreRecord match(@PathVariable Long studentAId,
                                          @PathVariable Long studentBId) {
        return service.computeScore(studentAId, studentBId);
    }
}
