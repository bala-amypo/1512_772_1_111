package com.example.demo.controller;

import com.example.demo.model.MatchResult;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/compute")
    public MatchResult computeMatch(
            @RequestParam Long studentAId,
            @RequestParam Long studentBId) {

        return matchService.computeMatch(studentAId, studentBId);
    }

    @GetMapping("/student/{studentId}")
    public List<MatchResult> getMatchesForStudent(
            @PathVariable Long studentId) {

        return matchService.getMatchesFor(studentId);
    }

    @GetMapping("/{id}")
    public MatchResult getById(@PathVariable Long id) {
        return matchService.getById(id);
    }
}
