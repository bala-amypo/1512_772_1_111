package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    public HabitProfile createOrUpdateHabit(HabitProfile h) {
        h.setUpdatedAt(LocalDateTime.now());
        return repo.save(h);
    }

    public HabitProfile getHabitByStudent(Long id) {
        return repo.findByStudentId(id).orElse(null);
    }

    public HabitProfile getHabitById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<HabitProfile> getAllHabits() {
        return repo.findAll();
    }
}
