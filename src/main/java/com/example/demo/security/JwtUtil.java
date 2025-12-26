package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username, String role) {
        return username + ":" + role;
    }

    public boolean validateToken(String token) {
        return token != null && token.contains(":");
    }

    public String extractUsername(String token) {
        return token.split(":")[0];
    }
}
