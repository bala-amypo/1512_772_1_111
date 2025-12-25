package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private int statusCode;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
        this.statusCode = 200;
    }

    public String getToken() {
        return token;
    }

    public int getStatusCodeValue() {
        return statusCode;
    }
}
