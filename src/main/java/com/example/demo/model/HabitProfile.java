package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String sleepSchedule;
    private Integer studyHoursPerDay;
    private String cleanlinessLevel;
    private String noiseTolerance;
    private String socialPreference;
    private LocalDateTime updatedAt;

    public HabitProfile() {}

}
