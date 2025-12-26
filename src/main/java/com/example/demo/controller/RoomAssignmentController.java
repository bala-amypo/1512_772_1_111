package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-assignments")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord r) {
        return ResponseEntity.ok(service.assignRoom(r));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<RoomAssignmentRecord> update(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<RoomAssignmentRecord>> getForStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAssignmentsByStudent(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomAssignmentRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAssignmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoomAssignmentRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAssignments());
    }
}
