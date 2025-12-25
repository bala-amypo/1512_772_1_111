package com.example.demo.dto;

public class HabitProfileDto {

    private boolean smoking;
    private boolean drinking;

    private String sleepTime;
    private String wakeTime;

    private int cleanlinessLevel; // 1–5
    private int noisePreference;  // 1–5

    private String studyStyle;
    private String socialPreference;
    private int visitorsFrequency;

    public HabitProfileDto() {}

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public void setDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getWakeTime() {
        return wakeTime;
    }

    public void setWakeTime(String wakeTime) {
        this.wakeTime = wakeTime;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public int getNoisePreference() {
        return noisePreference;
    }

    public void setNoisePreference(int noisePreference) {
        this.noisePreference = noisePreference;
    }

    public String getStudyStyle() {
        return studyStyle;
    }

    public void setStudyStyle(String studyStyle) {
        this.studyStyle = studyStyle;
    }

    public String getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(String socialPreference) {
        this.socialPreference = socialPreference;
    }

    public int getVisitorsFrequency() {
        return visitorsFrequency;
    }

    public void setVisitorsFrequency(int visitorsFrequency) {
        this.visitorsFrequency = visitorsFrequency;
    }
}
