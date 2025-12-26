package com.example.demo.controller;

import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-assignments")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }
}
