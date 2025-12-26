package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    // 🔹 TEST EXPECTS THIS METHOD NAME: assign(RoomAssignmentRecord)
    @PostMapping("/assign")
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord record) {
        return ResponseEntity.ok(service.assignRoom(record));
    }

    @GetMapping
    public ResponseEntity<List<RoomAssignmentRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomAssignmentRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAssignmentById(id));
    }
}
