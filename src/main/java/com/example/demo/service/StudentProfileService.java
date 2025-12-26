package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile profile);

    StudentProfile getStudentById(long id);

    StudentProfile findByStudentId(String studentId);

    List<StudentProfile> getAllStudents();
}
