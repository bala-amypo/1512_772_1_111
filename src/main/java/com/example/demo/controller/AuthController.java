package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwt;
    private final ConcurrentHashMap<String, AuthRequest> users = new ConcurrentHashMap<>();

    public AuthController(JwtUtil jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest r) {
        if (users.containsKey(r.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        users.put(r.getUsername(), r);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest r) {
        AuthRequest u = users.get(r.getUsername());
        if (u == null || !u.getPassword().equals(r.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(jwt.generateToken(r.getUsername(), r.getRole(), r.getEmail(), "1"));
    }
}
