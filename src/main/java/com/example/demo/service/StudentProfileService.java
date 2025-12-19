package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repository;

    // Constructor Injection (REQUIRED)
    public StudentProfileService(StudentProfileRepository repository) {
        this.repository = repository;
    }

    public StudentProfile createStudent(StudentProfile profile) {
        repository.findByStudentId(profile.getStudentId())
                .ifPresent(s -> {
                    throw new IllegalArgumentException("studentId exists");
                });

        profile.setActive(true);
        return repository.save(profile);
    }

    public StudentProfile getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("student not found"));
    }

    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    // ✅ ADD THIS METHOD (THIS FIXES YOUR ERROR)
    public StudentProfile updateStudentStatus(Long id, boolean active) {

        StudentProfile student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("student not found"));

        student.setActive(active);
        return repository.save(student);
    }
}
