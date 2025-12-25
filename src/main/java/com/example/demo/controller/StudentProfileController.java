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
public ResponseEntity<StudentProfile> get(@PathVariable long id) {
    return ResponseEntity.ok(service.getStudentById(id).orElseThrow());
}

@GetMapping("/lookup/{studentId}")
public ResponseEntity<StudentProfile> lookup(@PathVariable String studentId) {
    return ResponseEntity.ok(service.findByStudentId(studentId).orElseThrow());
}

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StudentProfile> updateStatus(@PathVariable long id,
                                                       @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateStudentStatus(id, active));
    }

    @GetMapping("/lookup/{studentId}")
    public ResponseEntity<StudentProfile> lookup(@PathVariable String studentId) {
        return ResponseEntity.ok(service.findByStudentId(studentId));
    }
}
