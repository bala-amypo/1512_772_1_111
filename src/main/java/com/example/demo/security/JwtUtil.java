package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

@Component
public class JwtUtil {

    public String generateToken(String username, String role, String email, String id) {
        String raw = username + ":" + role + ":" + email + ":" + id + ":" + UUID.randomUUID();
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public void validate(String token) {
        try {
            Base64.getDecoder().decode(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
