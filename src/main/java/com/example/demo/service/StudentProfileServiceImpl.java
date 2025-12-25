package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
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

    @Override
    public StudentProfile createStudent(StudentProfile profile) {
        profile.setCreatedAt(LocalDateTime.now());
        return repo.save(profile);
    }

    @Override
    public Optional<StudentProfile> getStudentById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Optional<StudentProfile> findByStudentId(String studentId) {
        return repo.findByStudentId(studentId);
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        p.setActive(active);
        return repo.save(p);
    }
}
