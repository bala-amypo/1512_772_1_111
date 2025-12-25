package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository r, HabitProfileRepository h) {
        this.repo = r;
        this.habitRepo = h;
    }

    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        HabitProfile A = habitRepo.findByStudentId(a).orElseThrow();
        HabitProfile B = habitRepo.findByStudentId(b).orElseThrow();

        double score = 100 - Math.abs(A.getStudyHoursPerDay() - B.getStudyHoursPerDay()) * 5;

        CompatibilityScoreRecord rec = new CompatibilityScoreRecord();
        rec.setStudentAId(a);
        rec.setStudentBId(b);
        rec.setScore(score);
        return repo.save(rec);
    }

    public List<CompatibilityScoreRecord> getScoresForStudent(Long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    public CompatibilityScoreRecord getScoreById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
