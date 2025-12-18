package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile saveHabit(HabitProfile h) {
        h.setUpdatedAt(LocalDateTime.now());
        return repo.save(h);
    }

    @Override
    public List<HabitProfile> getAllHabits() {
        return repo.findAll();
    }
}
