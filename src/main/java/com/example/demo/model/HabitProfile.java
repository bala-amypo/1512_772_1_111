package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "habit_profiles")
public class HabitProfile {

    public enum SleepSchedule { EARLY, REGULAR, LATE }
    public enum Level { LOW, MEDIUM, HIGH }
    public enum SocialPreference { INTROVERT, BALANCED, EXTROVERT }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private Level cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private Level noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    private LocalDateTime updatedAt = LocalDateTime.now();

    public HabitProfile() {}

    // getters and setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }

    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public SleepSchedule getSleepSchedule() { return sleepSchedule; }

    public void setSleepSchedule(SleepSchedule sleepSchedule) { this.sleepSchedule = sleepSchedule; }

    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }

    public void setStudyHoursPerDay(Integer studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }

    public Level getCleanlinessLevel() { return cleanlinessLevel; }

    public void setCleanlinessLevel(Level cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public Level getNoiseTolerance() { return noiseTolerance; }

    public void setNoiseTolerance(Level noiseTolerance) { this.noiseTolerance = noiseTolerance; }

    public SocialPreference getSocialPreference() { return socialPreference; }

    public void setSocialPreference(SocialPreference socialPreference) { this.socialPreference = socialPreference; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
