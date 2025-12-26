package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile create(StudentProfile profile) {
        return repo.save(profile);
    }

    @Override
    public List<StudentProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public StudentProfile getById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
