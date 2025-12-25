package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo,
                                         HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long studentAId, Long studentBId) {

        if (studentAId.equals(studentBId)) {
            throw new IllegalArgumentException("same student");
        }

        HabitProfile a = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        HabitProfile b = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        double score = 100;

        if (a.getSleepSchedule() != b.getSleepSchedule()) score -= 10;
        if (a.getCleanlinessLevel() != b.getCleanlinessLevel()) score -= 10;
        if (a.getNoiseTolerance() != b.getNoiseTolerance()) score -= 10;
        if (a.getSocialPreference() != b.getSocialPreference()) score -= 10;

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(studentAId);
        record.setStudentBId(studentBId);
        record.setScore(score);
        record.setCompatibilityLevel(
                score >= 80 ? CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT :
                        score >= 60 ? CompatibilityScoreRecord.CompatibilityLevel.HIGH :
                                score >= 40 ? CompatibilityScoreRecord.CompatibilityLevel.MEDIUM :
                                        CompatibilityScoreRecord.CompatibilityLevel.LOW
        );
        record.setDetailsJson("{\"computed\":true}");

        return scoreRepo.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
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
