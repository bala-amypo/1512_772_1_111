package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HabitProfile;

public interface HabitProfileService {
    HabitProfile saveHabit(HabitProfile habit);
    List<HabitProfile> getAllHabits();
}
