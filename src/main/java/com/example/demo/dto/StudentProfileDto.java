package com.example.demo.dto;

public class StudentProfileDto {

    private Long userId;

    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private String gender;

    private String roomTypePreference;

    private boolean smoking;
    private boolean drinking;

    private String sleepTime;
    private String wakeTime;

    private int noiseTolerance;
    private String studyTime;

    public StudentProfileDto() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoomTypePreference() {
        return roomTypePreference;
    }

    public void setRoomTypePreference(String roomTypePreference) {
        this.roomTypePreference = roomTypePreference;
    }

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

    public int getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(int noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }
}
