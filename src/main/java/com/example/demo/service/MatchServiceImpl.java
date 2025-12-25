package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.MatchResult;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.MatchResultRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final StudentProfileRepository studentRepo;
    private final HabitProfileRepository habitRepo;
    private final MatchResultRepository matchRepo;

    public MatchServiceImpl(StudentProfileRepository studentRepo,
                            HabitProfileRepository habitRepo,
                            MatchResultRepository matchRepo) {
        this.studentRepo = studentRepo;
        this.habitRepo = habitRepo;
        this.matchRepo = matchRepo;
    }

    @Override
    public MatchResult computeMatch(Long studentAId, Long studentBId) {

        StudentProfile a = studentRepo.findById(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentProfile b = studentRepo.findById(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        HabitProfile ha = habitRepo.findByStudentId(studentAId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        HabitProfile hb = habitRepo.findByStudentId(studentBId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double score = calculateScore(ha, hb);

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score must be between 0-100");
        }

        MatchResult result = new MatchResult();
        result.setStudentA(a);
        result.setStudentB(b);
        result.setScore(score);
        result.setReasonSummary("Auto-calculated compatibility");

        return matchRepo.save(result);
    }

    @Override
    public List<MatchResult> getMatchesFor(Long studentId) {
        return matchRepo.findByStudentAIdOrStudentBIdOrderByScoreDesc(studentId, studentId);
    }

    @Override
    public MatchResult getById(Long id) {
        return matchRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }

    private double calculateScore(HabitProfile a, HabitProfile b) {

        int total = 0;
        int matched = 0;

        total++; if (a.isSmoking() == b.isSmoking()) matched++;
        total++; if (a.isDrinking() == b.isDrinking()) matched++;
        total++; if (a.getSleepTime().equalsIgnoreCase(b.getSleepTime())) matched++;
        total++; if (a.getWakeTime().equalsIgnoreCase(b.getWakeTime())) matched++;
        total++; if (Math.abs(a.getCleanlinessLevel() - b.getCleanlinessLevel()) <= 1) matched++;
        total++; if (Math.abs(a.getNoisePreference() - b.getNoisePreference()) <= 1) matched++;

        double ratio = (double) matched / total;
        return Math.round(ratio * 10000.0) / 100.0;
    }
}
