package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@Tag(name = "Habit Profiles")
public class HabitProfileController {

    private final HabitProfileService service;

    public HabitProfileController(HabitProfileService service) {
        this.service = service;
    }

    @PostMapping("/{studentId}")
    public HabitProfile createOrUpdate(
            @PathVariable Long studentId,
            @RequestBody HabitProfile habit) {

        return service.createOrUpdate(studentId, habit);
    }

    @GetMapping("/{studentId}")
    public HabitProfile getForStudent(@PathVariable Long studentId) {
        return service.getForStudent(studentId);
    }

    @GetMapping
    public List<HabitProfile> getAll() {
        return service.getAll();
    }
}
