package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        student.setCreatedAt(LocalDateTime.now());
        student.setActive(true);
        return repo.save(student);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }
}
