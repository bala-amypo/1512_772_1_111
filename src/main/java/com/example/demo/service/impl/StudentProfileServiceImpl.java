package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile createStudent(StudentProfile profile) {
        profile.setCreatedAt(LocalDateTime.now());
        return repo.save(profile);
    }

    public Optional<StudentProfile> getStudentById(Long id) {
        return repo.findById(id);
    }

    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    public Optional<StudentProfile> findByStudentId(String studentId) {
        return repo.findByStudentId(studentId);
    }

    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile s = repo.findById(id).orElseThrow();
        s.setActive(active);
        return repo.save(s);
    }
}
