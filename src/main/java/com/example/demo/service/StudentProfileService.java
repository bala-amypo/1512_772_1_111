package com.example.demo.service;

import java.util.List;

import com.example.demo.model.StudentProfile;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile student);
    List<StudentProfile> getAllStudents();
}
