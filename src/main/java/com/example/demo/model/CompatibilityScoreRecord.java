package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompatibilityScoreRecord {

    public enum CompatibilityLevel { LOW, MEDIUM, HIGH, EXCELLENT }

    @Id @GeneratedValue
    private Long id;
    private Long studentAId;
    private Long studentBId;
    private Double score;

    @Enumerated(EnumType.STRING)
    private CompatibilityLevel compatibilityLevel;

    private LocalDateTime computedAt;
    private String detailsJson;

    // getters & setters
}
