package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> create(@RequestBody StudentProfile p) {
        return ResponseEntity.ok(service.createStudent(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/lookup/{studentId}")
    public ResponseEntity<StudentProfile> lookup(@PathVariable String studentId) {
        return ResponseEntity.ok(service.findByStudentId(studentId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StudentProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateStudentStatus(id, active));
    }
}
