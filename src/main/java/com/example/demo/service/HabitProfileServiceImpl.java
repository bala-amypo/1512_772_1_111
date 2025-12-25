package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) { this.repo = repo; }

    public HabitProfile createOrUpdate(Long studentId, HabitProfile habit) {
        habit.setStudentId(studentId);
        habit.setUpdatedAt(LocalDateTime.now());
        return repo.save(habit);
    }

    public HabitProfile getForStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    public List<HabitProfile> getAll() {
        return repo.findAll();
    }
}
