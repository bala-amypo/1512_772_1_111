package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.CompatibilityScore;

public interface CompatibilityScoreRepository
        extends JpaRepository<CompatibilityScore, Long> {
}
