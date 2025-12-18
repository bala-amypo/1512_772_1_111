package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;

@RestController
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/addhabit")
    public HabitProfile add(@RequestBody HabitProfile h) {
        return service.saveHabit(h);
    }

    @GetMapping("/showhabits")
    public List<HabitProfile> show() {
        return service.getAllHabits();
    }
}
