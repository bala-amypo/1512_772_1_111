package com.example.demo.controller;

import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }
}
