package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CompatibilityScore;
import com.example.demo.service.CompatibilityScoreService;

@RestController
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(
            CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/addscore")
    public CompatibilityScore add(
            @RequestBody CompatibilityScore cs) {
        return service.addScore(cs);
    }

    @GetMapping("/showscores")
    public List<CompatibilityScore> show() {
        return service.getAllScores();
    }
}
