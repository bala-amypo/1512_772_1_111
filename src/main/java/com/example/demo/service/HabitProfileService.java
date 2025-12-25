package com.example.demo.service;

import com.example.demo.model.HabitProfile;

import java.util.List;

public interface HabitProfileService {

    HabitProfile createOrUpdate(Long studentId, HabitProfile habit);

    HabitProfile getForStudent(Long studentId);

    List<HabitProfile> getAll();
}
