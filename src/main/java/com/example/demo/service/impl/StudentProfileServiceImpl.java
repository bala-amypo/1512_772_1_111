package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentProfileRepository repo;

    public StudentServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile s) {
        if (repo.existsByStudentId(s.getStudentId())) {
            throw new IllegalArgumentException("Duplicate studentId");
        }
        return repo.save(s);
    }

    @Override
    public StudentProfile getStudentByStudentId(long studentId) {
        return repo.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}
