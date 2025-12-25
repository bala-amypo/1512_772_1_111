package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtUtil jwt;

    public AuthController(AuthenticationManager manager, JwtUtil jwt) {
        this.manager = manager;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        return new AuthResponse(jwt.generateToken(req.getUsername()));
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest req) {
        return new AuthResponse(jwt.generateToken(req.getUsername()));
    }
}
