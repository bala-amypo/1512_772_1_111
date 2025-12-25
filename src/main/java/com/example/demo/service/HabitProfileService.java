package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileService {
    HabitProfile createOrUpdateHabit(HabitProfile habit);
    HabitProfile getHabitByStudent(Long id);
    HabitProfile getHabitById(Long id);
    List<HabitProfile> getAllHabits();
}
