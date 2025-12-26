package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo,
                                         HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        if (a.equals(b)) throw new IllegalArgumentException("same student");

        HabitProfile ha = habitRepo.findByStudentId(a)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        HabitProfile hb = habitRepo.findByStudentId(b)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double score = 100;
        if (!ha.getSleepSchedule().equals(hb.getSleepSchedule())) score -= 20;

        CompatibilityScoreRecord rec =
                scoreRepo.findByStudentAIdAndStudentBId(a, b).orElse(new CompatibilityScoreRecord());

        rec.setStudentAId(a);
        rec.setStudentBId(b);
        rec.setScore(score);
        rec.setComputedAt(LocalDateTime.now());
        rec.setCompatibilityLevel(score >= 90
                ? CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT
                : CompatibilityScoreRecord.CompatibilityLevel.HIGH);

        return scoreRepo.save(rec);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return scoreRepo.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
