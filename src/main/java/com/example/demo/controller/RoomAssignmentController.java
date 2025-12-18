package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;

@RestController
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/addroom")
    public RoomAssignmentRecord add(@RequestBody RoomAssignmentRecord r) {
        return service.addRoom(r);
    }

    @GetMapping("/showrooms")
    public List<RoomAssignmentRecord> show() {
        return service.getAllRooms();
    }
}
