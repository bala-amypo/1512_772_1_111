package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private StudentProfile student;

    private boolean smoking;
    private boolean drinking;

    private String sleepTime;
    private String wakeTime;

    private int cleanlinessLevel;   // 1–5
    private int noisePreference;    // 1–5

    public HabitProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentProfile getStudent() { return student; }
    public void setStudent(StudentProfile student) { this.student = student; }

    public boolean isSmoking() { return smoking; }
    public void setSmoking(boolean smoking) { this.smoking = smoking; }

    public boolean isDrinking() { return drinking; }
    public void setDrinking(boolean drinking) { this.drinking = drinking; }

    public String getSleepTime() { return sleepTime; }
    public void setSleepTime(String sleepTime) { this.sleepTime = sleepTime; }

    public String getWakeTime() { return wakeTime; }
    public void setWakeTime(String wakeTime) { this.wakeTime = wakeTime; }

    public int getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(int cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public int getNoisePreference() { return noisePreference; }
    public void setNoisePreference(int noisePreference) { this.noisePreference = noisePreference; }
}
