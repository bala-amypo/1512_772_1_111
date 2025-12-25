package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private boolean smoking;
    private boolean drinking;
    private int sleepTime;
    private int wakeTime;
    private int noisePreference;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    public enum CleanlinessLevel { LOW, MEDIUM, HIGH }

    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public boolean isSmoking() { return smoking; }
    public boolean isDrinking() { return drinking; }
    public int getSleepTime() { return sleepTime; }
    public int getWakeTime() { return wakeTime; }
    public int getNoisePreference() { return noisePreference; }
    public CleanlinessLevel getCleanlinessLevel() { return cleanlinessLevel; }

    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setSmoking(boolean smoking) { this.smoking = smoking; }
    public void setDrinking(boolean drinking) { this.drinking = drinking; }
    public void setSleepTime(int sleepTime) { this.sleepTime = sleepTime; }
    public void setWakeTime(int wakeTime) { this.wakeTime = wakeTime; }
    public void setNoisePreference(int noisePreference) { this.noisePreference = noisePreference; }
    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
}
