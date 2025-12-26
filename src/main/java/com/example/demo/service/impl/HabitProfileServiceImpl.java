package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile h) {
        if (h.getHoursPerDay() < 0 || h.getHoursPerDay() > 24) {
            throw new IllegalArgumentException("Invalid hours");
        }

        Optional<HabitProfile> existing =
                repo.findByStudentAndHabitName(h.getStudent(), h.getHabitName());

        if (existing.isPresent()) {
            HabitProfile e = existing.get();
            e.setHoursPerDay(h.getHoursPerDay());
            return repo.save(e);
        }

        return repo.save(h);
    }

    @Override
    public HabitProfile getHabitById(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }
}
