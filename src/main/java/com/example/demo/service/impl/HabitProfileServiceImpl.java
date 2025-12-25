package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        habit.setUpdatedAt(LocalDateTime.now());
        return repo.save(habit);
    }

    @Override
    public Optional<HabitProfile> getHabitByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repo.findAll();
    }
}
