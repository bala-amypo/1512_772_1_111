package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "student-profile-controller")
public class StudentProfileController {

    private final StudentProfileService service;

    // Constructor Injection
    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    // POST – create student
    @PostMapping("/addstudent")
    public StudentProfile addStudent(@RequestBody StudentProfile student) {
        return service.createStudent(student);
    }

    // GET – list all students
    @GetMapping("/showstudents")
    public List<StudentProfile> showStudents() {
        return service.getAllStudents();
    }

    // ✅ PUT – activate / deactivate student  ← INSERTED HERE
    @PutMapping("/{id}/status")
    public StudentProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return service.updateStudentStatus(id, active);
    }
}

