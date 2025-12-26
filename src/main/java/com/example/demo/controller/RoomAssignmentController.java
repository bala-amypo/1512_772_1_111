package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomAssignmentRecord> assign(@RequestBody RoomAssignmentRecord r) {
        return ResponseEntity.ok(service.assignRoom(r)); // <-- FIXED
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomAssignmentRecord> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getAssignmentById(id));
    }
}
