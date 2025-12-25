package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRepository repo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRepository r, HabitProfileRepository h) {
        this.repo = r;
        this.habitRepo = h;
    }

    public CompatibilityScore computeScore(Long a, Long b) {
        HabitProfile A = habitRepo.findByStudentId(a).orElseThrow();
        HabitProfile B = habitRepo.findByStudentId(b).orElseThrow();

        double score = 100 - Math.abs(A.getStudyHoursPerDay() - B.getStudyHoursPerDay()) * 5;

        CompatibilityScore cs = new CompatibilityScore();
        cs.setStudentAId(a);
        cs.setStudentBId(b);
        cs.setScore(score);
        return repo.save(cs);
    }

    public List<CompatibilityScore> getAllScores() {
        return repo.findAll();
    }
}
