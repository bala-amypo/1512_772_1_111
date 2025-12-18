package com.example.ammo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ammo.model.StudentProfile;
import com.example.ammo.service.StudentProfileService;

@RestController
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping("/addstudent")
    public StudentProfile add(@RequestBody StudentProfile s) {
        return service.createStudent(s);
    }

    @GetMapping("/showstudents")
    public List<StudentProfile> show() {
        return service.getAllStudents();
    }
}
