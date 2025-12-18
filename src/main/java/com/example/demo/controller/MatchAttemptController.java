package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;

@RestController
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping("/addattempt")
    public MatchAttemptRecord add(@RequestBody MatchAttemptRecord m) {
        return service.addAttempt(m);
    }

    @GetMapping("/showattempts")
    public List<MatchAttemptRecord> show() {
        return service.getAllAttempts();
    }
}
